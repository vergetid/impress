package eu.impress.repository.service;

import eu.impress.repository.dao.TextDAO;
import eu.impress.repository.model.incicrowd.*;
import eu.impress.repository.model.incicrowd.Thread;
import eu.impress.repository.util.incicrowd.DistanceUtil;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim on 19/2/2017.
 */
@Component
public class TextDAOImpl implements TextDAO {
    //@Value("${spring.datasource.url}")
    private String url = "jdbc:mysql://localhost/ImpressIntegration";
    //@Value("${spring.datasource.username}")
    private String user = "root";
    //@Value("${spring.datasource.password}")
    private String password = "merootme";
    //@Value("${spring.datasource.driver-class-name}")
    private String driver = "com.mysql.jdbc.Driver";

    @Override
    public void saveText(SendTextMessage text) throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection connection = DriverManager
                .getConnection(url,user, password);

        String sql = "INSERT INTO Test " +
                "SET offerNeedID = ?, "
                + "threadID = ?, "
                + "messageID = ?, "
                + "time=?,"
                + "messageContent = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, text.getOfferNeedID());
            ps.setString(2, text.getThreadId());
            ps.setString(3, text.getMessageId());
            ps.setLong(4, text.getTime());
            ps.setString(5, text.getMessageContent());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
        return;

    }

    @Override
    public GetTextsResponseBody getTexts(GetTextMessages getTextMessages) throws SQLException {
        GetTextsResponseBody getTextsResponseBody = new GetTextsResponseBody();
        String threadId = null;
        if (getTextMessages.getThreadId() != null) {
            threadId = getTextMessages.getThreadId();
        }
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection connection = DriverManager
                .getConnection(url,user, password);

        String sql = "SELECT * FROM TextMessage WHERE offerNeedID=?";
        if (threadId != null) {
            sql += " AND threadId = ?";
        }
        List<Thread> threads = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, getTextMessages.getOfferNeedID());
            if (threadId != null) {
                ps.setString(2, threadId);
            }
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Message message = new Message();
                message.setTime(rs.getLong("time"));
                message.setMessageContent(rs.getString("messageContent"));
                message.setMessageId(rs.getString("messageId"));
                String returnedThreadId = rs.getString("threadId");
                Thread thread = findInThreads(threads, returnedThreadId);
                if (thread == null) {
                    thread = new Thread();
                    thread.setThreadId(returnedThreadId);
                    thread.getMessages().add(message);
                    threads.add(thread);
                } else {
                    thread.getMessages().add(message);
                }

            }
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
        getTextsResponseBody.setResponse("SUCCESS");
        getTextsResponseBody.setThreads(threads);
        return getTextsResponseBody;
    }
    private Thread findInThreads(List<Thread> threads, String threadId) {

        for (Thread thread: threads) {
            if (thread.getThreadId().equals(threadId)) {
                return thread;
            }
        }
        return null;
    }
}
