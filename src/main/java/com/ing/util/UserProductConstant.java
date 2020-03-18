package com.ing.util;

/**
 * Constant & static information for user & product details which is used in application
 */
public class UserProductConstant {

    private static final String ERR_GET_PROD_LIST="error occured while retrieving list of products";
    private static final String ERR_GET_PROD_DETAIL="error occured while retrieving product details";
    private static final String ERR_GET_PROD_GROUP="error occured while retrieving product groups";
    private static final String ERR_GET_USERS="error occured while retrieving all users";

    public enum ProcessingError {
        GET_PROD_LIST_ERROR(ERR_GET_PROD_LIST),
        GET_PROD_DETAIL_ERROR(ERR_GET_PROD_DETAIL),
        GET_PROD_GROUP_ERROR(ERR_GET_PROD_GROUP),
        GET_USERS_ERROR(ERR_GET_USERS);

        private String errorDesc;

        ProcessingError(final String errorDesc) {
            this.errorDesc = errorDesc;
        }

        public String getErrorDesc() {
            return errorDesc;
        }
    }
}
