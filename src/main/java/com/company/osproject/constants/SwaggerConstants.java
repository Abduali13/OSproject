package com.company.osproject.constants;

public class SwaggerConstants {



    public static final String EXAMPLE_HOUSE_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {
                    "Value...":"Value..."
                 }
            }
            """;


    public static final String EXAMPLE_HOUSE_BAD_REQUEST = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Houses are not found"
            }
            """;

    public static final String EXAMPLE_HOUSE_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Houses are not found"
            }
            """;

    public static final String EXAMPLE_HOUSE_INTERNAL_SERVER_ERROR = """
            {
                "success":"false",
                 "code":"-1",
                 "message":"Houses are not found"
            }
            """;

    public static final String EXAMPLE_CUSTOMER_SUCCESS = """
            {
                "success":"true",
                "code":"0",
                "message":"OK",
                "data":{
                    "Value...":"Value..."
                }
            }
            """;

    public static final String EXAMPLE_CUSTOMER_BAD_REQUEST = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Customers are not found"
            }
            """;

    public static final String EXAMPLE_CUSTOMER_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Customers are not found"
            }
            """;

    public static final String EXAMPLE_CUSTOMER_INTERNAL_SERVER_ERROR = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Customers are not found"
            }
            """;


    public static final String EXAMPLE_ADDRESS_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data":{
                    "Value...":"Value..."
                 }
            }
            """;

    public static final String EXAMPLE_ADDRESS_BAD_REQUEST = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Addresses are not found"
            }
            """;

    public static final String EXAMPLE_ADDRESS_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Addresses are not found"
            }
            """;

    public static final String EXAMPLE_ADDRESS_INTERNAL_SERVER_ERROR = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Addresses are not found"
            }
            """;

}
