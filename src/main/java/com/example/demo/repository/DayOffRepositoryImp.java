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

        String query = String.format("INSERT day_off values('%s', %f, N'%s', %d);",
            obj.getDate().toString(),
            obj.getNumberDay(),
            obj.getComment(),
            obj.getStatus()
        );

        try(Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        //System.out.println(query);

        return obj;
    }

    @Override
    public boolean update(int id, DayOff obj) {

        String query = String.format("UPDATE day_off\n" +
                "SET\n" +
                "    date = '%s',\n" +
                "    number = %f,\n" +
                "    comment = N'%s',\n" +
                "    status = %d\n" +
                "WHERE\n" +
                "    id = %d;",
                obj.getDate().toString(),
                obj.getNumberDay(),
                obj.getComment(),
                obj.getStatus(),
                id);

        try(Statement statement = connection.createStatement()) {
            return statement.executeUpdate(query) > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
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
            dayOff.setStatus(resultSet.getInt(5));

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
                dayOff.setStatus(resultSet.getInt(5));

                dayOffs.add(dayOff);
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        return dayOffs;
    }
}
