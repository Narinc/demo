package com.kahvedunyasi.barista.util;

public final class AppConstants {

    public static final String NULL_INDEX = "";

    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String STATUS_CODE_FAILED = "failed";

    public static final String PREF_NAME = "project_base_pref";

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";
    public static final int MAX_NAME_LENGTH = 50;
    public static final int MAX_EMAIL_LENGTH = 50;
    public static final int MAX_PASS_LENGTH = 50;
    public static final int MIN_NAME_LENGTH = 3;
    public static final int MIN_EMAIL_LENGTH = 3;
    public static final int MIN_PASS_LENGTH = 3;

    public static class Intent{
        public static final String CATEGORY_ID = "category_id";
        public static final String SHOP_ID = "shop_id";
        public static final String BRAND_ID = "brand_id";
        public static final String ORDER_ID = "order_id";
        public static final String CATEGORY_MODEL = "category_model";
        public static final String BRAND_MODEL = "brand_model";
        public static final String SHOP_MODEL = "shop_model";
        public static final String ORDER_MODEL = "order_model";

    }

    public static class WebSocket{
        public static final String REVERSE_AUCTION_SOCKET = "ws://34.250.187.79:9234/";
        public static final String TIME_LIMITED_SOCKET = "ws://34.250.187.79:9293/";
        public static final String BINGO_SOCKET = "ws://34.250.187.79:8285/";
        public static final String QUIZ_SOCKET = "ws://34.250.187.79:9293/";

    }

    public static final String DUMMY_PRODUCT_MODEL = "{\n" +
            "        \"_id\": \"5b0d43ad565556426c28b90b\",\n" +
            "        \"title\": \"Halısaha Ayakkabısı\",\n" +
            "        \"images\": [\"http://static.barcin.com/web/images/products/684853-018/nike-cristiano-ronaldo-jr-mercurial-victory-ss15-cocuk-hali-saha-ayakkabisi-original-big.jpg\", \"http://static.barcin.com/web/images/products/684853-018/nike-cristiano-ronaldo-jr-mercurial-victory-ss15-cocuk-hali-saha-ayakkabisi-original-big.jpg\"],\n" +
            "        \"shortDesc\": \"Short Descr\",\n" +
            "        \"desc\": \"Test description\",\n" +
            "        \"price\": 120,\n" +
            "        \"discountPrice\": 100,\n" +
            "        \"quantity\": 10,\n" +
            "        \"category\": {\n" +
            "          \"name\": \"Ayakkabı\",\n" +
            "          \"val\": \"1\"\n" +
            "        },\n" +
            "        \"brand\": {\n" +
            "          \"name\": \"Nike\",\n" +
            "          \"val\": \"1\"\n" +
            "        },\n" +
            "        \"variants\": null,\n" +
            "        \"stockCode\": \"1001\",\n" +
            "        \"updatedDate\": \"2018-05-29T15:12:23.597+03:00\",\n" +
            "        \"status\": true,\n" +
            "        \"isDeleted\": false,\n" +
            "        \"isNew\": true,\n" +
            "        \"freeCargo\": true,\n" +
            "        \"createDate\": \"2018-05-29T15:12:20.963+03:00\",\n" +
            "        \"note1\": null,\n" +
            "        \"note2\": null,\n" +
            "        \"note3\": null,\n" +
            "        \"shop\": {\n" +
            "          \"name\": \"Boyner\",\n" +
            "          \"val\": \"1\"\n" +
            "        }\n" +
            "      }";

    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
