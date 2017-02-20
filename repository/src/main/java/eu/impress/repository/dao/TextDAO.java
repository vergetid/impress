package eu.impress.repository.dao;

import eu.impress.repository.model.incicrowd.GetTextMessages;
import eu.impress.repository.model.incicrowd.GetTextsResponseBody;
import eu.impress.repository.model.incicrowd.SendTextMessage;

import java.sql.SQLException;

/**
 * Created by jim on 19/2/2017.
 */
public interface TextDAO {
    public void saveText(SendTextMessage text) throws SQLException;
    GetTextsResponseBody getTexts(GetTextMessages getTextMessages) throws SQLException;
}
