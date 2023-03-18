package org.pcdd.javase.university.javaweb第2次和第3次作业;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * @author pcdd
 * date 2021/4/14 11:02
 */
public class JsonUtils {

    public static List<Map<String, Object>> toList(ResultSet resultSet) {
        if (resultSet == null) {
            try {
                throw new JsonParseException("Result对象为null");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        List<Map<String, Object>> list = new ArrayList<>();


        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 遍历行
            while (resultSet.next()) {
                Map<String, Object> map = new Hashtable<>();

                // 遍历列，K作为字段名，V为对应的值 注意：下标从1开始
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    map.put(metaData.getColumnName(i), resultSet.getObject(i));
                }

                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}

class JsonParseException extends Exception {
    public JsonParseException(String message) {
        super(message);
    }
}
