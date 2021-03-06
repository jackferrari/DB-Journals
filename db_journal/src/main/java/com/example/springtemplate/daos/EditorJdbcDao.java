package com.example.springtemplate.daos;

import com.example.springtemplate.models.Article;
import com.example.springtemplate.models.Editor;
import com.example.springtemplate.models.Role;
import com.example.springtemplate.models.User;

import java.sql.*;
import java.util.*;

public class EditorJdbcDao {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String HOST = "localhost:3306";
    static final String SCHEMA = "db_journals";
    static final String CONFIG = "serverTimezone=UTC";
    static final String URL =
            "jdbc:mysql://"+HOST+"/"+SCHEMA+"?"+CONFIG;
    static final String USERNAME = "root";
    static final String PASSWORD = "P@ssw0rd";

    static Connection connection = null;
    static PreparedStatement statement = null;
    String CREATE_EDITOR = "INSERT INTO editors VALUES (null, ?, null)";
    String FIND_ALL_EDITORS = "SELECT * FROM editors";
    String FIND_EDITOR_BY_ID = "SELECT * FROM editors WHERE id=?";
    String FIND_ARTICLES_OF_EDITOR = "SELECT * FROM articles WHERE editor=?";
    String FIND_EDITOR_USERS = "SELECT users.first_name, users.last_name, users.username, users.username, users.password, users.email, users.date_of_birth " +
            "FROM users, editors WHERE users.id=editors.user_id";
    String DELETE_EDITOR = "DELETE FROM editors WHERE id=?";
    String UPDATE_EDITOR = "UPDATE editors SET role=? WHERE id=?";

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public Editor findEditorById(Integer id) throws SQLException, ClassNotFoundException {
        Editor editor = null;
        connection = getConnection();
        statement = connection.prepareStatement(FIND_EDITOR_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            editor = new Editor(
                    resultSet.getInt("editorId"),
                    Role.getRoleFromString(resultSet.getString("role")),
                    resultSet.getInt("userId")
            );
        }
        closeConnection(connection);
        return editor;
    }

    public Integer deleteEditor(Integer editorId) throws SQLException, ClassNotFoundException {
        Integer rowsDeleted = 0;
        connection = getConnection();
        statement = connection.prepareStatement(DELETE_EDITOR);
        statement.setInt(1, editorId);
        rowsDeleted = statement.executeUpdate();
        closeConnection(connection);
        return rowsDeleted;
    }

    public Integer updateEditor(Integer editorId, Editor newEditor) throws SQLException, ClassNotFoundException {
        Integer rowsUpdated = 0;
        connection = getConnection();
        statement = connection.prepareStatement(UPDATE_EDITOR);
        statement.setString(1, newEditor.getRole().description);
        statement.setInt(2, editorId);
        rowsUpdated = statement.executeUpdate();
        closeConnection(connection);
        return rowsUpdated;
    }

    public List<Editor> findAllEditors() throws ClassNotFoundException, SQLException {
        List<Editor> editors = new ArrayList<Editor>();
        connection = getConnection();
        statement = connection.prepareStatement(FIND_ALL_EDITORS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Editor editor = new Editor(
                    resultSet.getInt("editorId"),
                    Role.getRoleFromString(resultSet.getString("role")),
                    resultSet.getInt("userId")
            );
            editors.add(editor);
        }
        closeConnection(connection);
        return editors;
    }

    public List<Article> findArticlesOfEditor(Integer id) throws SQLException, ClassNotFoundException {
        List<Article> articles = new ArrayList<Article>();
        connection = getConnection();
        statement = connection.prepareStatement(FIND_ARTICLES_OF_EDITOR);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Article article = new Article(
                    resultSet.getString("title"),
                    resultSet.getString("content"),
                    resultSet.getString("bibliography"),
                    resultSet.getInt("author"),
                    resultSet.getInt("editor"),
                    resultSet.getInt("journal")
            );
            articles.add(article);
        }
        closeConnection(connection);
        return articles;
    }

    public List<User> findEditorUsers(Integer id) throws SQLException, ClassNotFoundException {
        List<User> users= new ArrayList<User>();
        connection = getConnection();
        statement = connection.prepareStatement(FIND_EDITOR_USERS);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            User user = new User(
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getString("date_of_birth")
            );
            users.add(user);
        }
        closeConnection(connection);
        return users;
    }

    public Integer createEditor(Editor editor)
            throws ClassNotFoundException, SQLException {
        Integer rowsUpdated = 0;
        connection = getConnection();
        statement = connection.prepareStatement(CREATE_EDITOR);
        statement.setString(1, editor.getRole().description);
        rowsUpdated = statement.executeUpdate();
        closeConnection(connection);
        return rowsUpdated;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("JDBC DAO");
        EditorJdbcDao dao = new EditorJdbcDao();

//        create new editors
//        Editor hawk = new Editor(1, Role.HEAD_EDITOR, 1);
//        Editor ttm = new Editor(2, Role.JUNIOR_EDITOR, 3);
//        dao.createEditor(hawk);
//        dao.createEditor(ttm);
//
//        list all editors
//        List<Editor> editors = dao.findAllEditors();
//        for(Editor editor: editors) {
//            System.out.println(editor.getEditorId());
//        }

//        find editor by id
//        Editor editor = dao.findEditorById(1);
//        System.out.println(author.getEditorId());
//
//        delete editor
//        dao.deleteEditor(1);
//        List<Editor> Editors = dao.findAllEditors();
//        for(Editor editor: editors) {
//            System.out.println(editor.getEditorId());
//        }
//
//        update editor
//        Editor ttmUpgraded = new Editor(2, Role.HEAD_EDITOR, 3);
//        dao.updateEditor(3, ttmUpgraded);
//        Editor tanktop = dao.findEditorById(3);
//        System.out.println(tanktop.getRole());

    }
}

