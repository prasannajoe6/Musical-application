package Database;

import android.provider.BaseColumns;

public final class UsersMaster {

    private UsersMaster() {
    }

    public static class UsersInfo implements BaseColumns{
        public static final String TABLE_NAME = "usersinfo";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_CURRENT_LEVEL = "currentlevel";
        public static final String COLUMN_NAME_LEVEL1_SCORE = "level1score";
        public static final String COLUMN_NAME_LEVEL2_SCORE = "level2score";
        public static final String COLUMN_NAME_LEVEL3_SCORE = "level3score";
        public static final String COLUMN_NAME_LEVEL4_SCORE = "level4score";
    }
}
