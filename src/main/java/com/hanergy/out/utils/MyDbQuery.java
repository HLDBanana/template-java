package com.hanergy.out.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.IDbQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description: 重写IDbQuery方法，mybatisplusutil工具类需要使用
 * @author: Han LiDong
 * @create: 2020-07-20 14:00:00
 * @update: 2020-07-20 14:00:00
 */
public class MyDbQuery implements IDbQuery {
    @Override
    public DbType dbType() {
        return DbType.ORACLE;
    }

    @Override
    public String tablesSql() {
        return "SELECT * FROM ALL_TAB_COMMENTS WHERE OWNER='%s'";
    }

    @Override
    public String tableFieldsSql() {
        return "SELECT A.COLUMN_NAME, CASE WHEN A.DATA_TYPE='NUMBER' THEN (CASE WHEN A.DATA_PRECISION IS NULL THEN A.DATA_TYPE WHEN NVL(A.DATA_SCALE, 0) > 0 THEN A.DATA_TYPE||'('||A.DATA_PRECISION||','||A.DATA_SCALE||')' ELSE A.DATA_TYPE||'('||A.DATA_PRECISION||')' END) ELSE A.DATA_TYPE END DATA_TYPE, B.COMMENTS,DECODE(C.POSITION, '1', 'PRI') KEY FROM ALL_TAB_COLUMNS A  INNER JOIN ALL_COL_COMMENTS B ON A.TABLE_NAME = B.TABLE_NAME AND A.COLUMN_NAME = B.COLUMN_NAME AND B.OWNER = '#schema' LEFT JOIN ALL_CONSTRAINTS D ON D.TABLE_NAME = A.TABLE_NAME AND D.CONSTRAINT_TYPE = 'P' AND D.OWNER = '#schema' LEFT JOIN ALL_CONS_COLUMNS C ON C.CONSTRAINT_NAME = D.CONSTRAINT_NAME AND C.COLUMN_NAME=A.COLUMN_NAME AND C.OWNER = '#schema'WHERE A.OWNER = '#schema' AND A.TABLE_NAME = '%s' ORDER BY A.COLUMN_ID ";
    }


    @Override
    public String tableName() {
        return "TABLE_NAME";
    }

    @Override
    public String tableComment() {
        return "COMMENTS";
    }

    @Override
    public String fieldName() {
        return "COLUMN_NAME";
    }


    @Override
    public String fieldType() {
        return "DATA_TYPE";
    }

    @Override
    public String fieldComment() {
        return "COMMENTS";
    }

    @Override
    public String fieldKey() {
        return "KEY";
    }

    @Override
    public boolean isKeyIdentity(ResultSet results) throws SQLException {
        return false;
    }

    @Override
    public String[] fieldCustom() {
        return new String[0];
    }


}
