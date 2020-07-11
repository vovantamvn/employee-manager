package com.example.demo.repository;

import com.example.demo.model.DayOff;
import com.example.demo.utils.SQLServerConnectionProvideImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DayOffRepositoryImp implements Repository<DayOff> {
    private Connection connection;

    public DayOffRepositoryImp() {
        SQLServerConnectionProvideImp connectionProvideImp = new SQLServerConnectionProvideImp();
        connection = connectionProvideImp.getConnection();

        if (connection == null) {
            throw new RuntimeException("SQL connection not must be null!");
        }
    }

    @Override
    public DayOff create(DayOff obj) {
        String status = "null";

        if (obj.getStatus() == DayOff.Status.ALLOW) {
            status = "1";
        } else if (obj.getStatus() == DayOff.Status.REFUSE) {
            status = "0";
        }

        String query = String.format("INSERT day_off values('%s', %f, N'%s', %s);",
            obj.getDate().toString(),
            obj.getNumberDay(),
            obj.getComment(),
            status
        );

        try(Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        System.out.println(query);

        return obj;
    }

    @Override
    public DayOff update(int id, DayOff obj) {
        String status = "null";

        if (obj.getStatus() == DayOff.Status.ALLOW) {
            status = "1";
        } else if (obj.getStatus() == DayOff.Status.REFUSE) {
            status = "0";
        }

        String query = String.format("UPDATE day_off\n" +
                "SET\n" +
                "    date = '%s',\n" +
                "    number = %f,\n" +
                "    comment = N'%s',\n" +
                "    status = %s\n" +
                "WHERE\n" +
                "    id = %d;",
                obj.getDate().toString(),
                obj.getNumberDay(),
                obj.getComment(),
                status,
                id);

        try(Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        System.out.println(query);

        return obj;
    }

    @Override
    public DayOff findById(int key) {
        String query = String.format("SELECT \n" +
                "    id,\n" +
                "    date,\n" +
                "    number,\n" +
                "    comment,\n" +
                "    status\n" +
                "FROM day_off\n" +
                "WHERE id = %d;", key);

        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            DayOff dayOff = new DayOff();
            dayOff.setId(resultSet.getInt(1));
            dayOff.setDate(LocalDate.parse(resultSet.getString(2)));
            dayOff.setNumberDay(resultSet.getFloat(3));
            dayOff.setComment(resultSet.getString(4));
            dayOff.setStatus(DayOff.Status.NULL);

            try {
                int status = resultSet.getByte(5);
                if (status == 0) {
                    dayOff.setStatus(DayOff.Status.REFUSE);
                } else {
                    dayOff.setStatus(DayOff.Status.ALLOW);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return dayOff;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteById(int key) {
        String query = String.format("DELETE day_off WHERE id = %d;", key);

        try(Statement statement = connection.createStatement()) {
            return statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public List<DayOff> getAll() {
        String query = String.format("SELECT \n" +
                "    id,\n" +
                "    date,\n" +
                "    number,\n" +
                "    comment,\n" +
                "    status\n" +
                "FROM day_off;");

        List<DayOff> dayOffs = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                DayOff dayOff = new DayOff();
                dayOff.setId(resultSet.getInt(1));
                dayOff.setDate(LocalDate.parse(resultSet.getString(2)));
                dayOff.setNumberDay(resultSet.getFloat(3));
                dayOff.setComment(resultSet.getString(4));
                dayOff.setStatus(DayOff.Status.NULL);

                try {;;
                    int status = resultSet.getInt(5);
                    if (status == 0) {
                        dayOff.setStatus(DayOff.Status.REFUSE);
                    } else {
                        dayOff.setStatus(DayOff.Status.ALLOW);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                dayOffs.add(dayOff);
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        return dayOffs;
    }
}
