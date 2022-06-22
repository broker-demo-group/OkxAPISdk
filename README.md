# OkxAPISdk

    ApiServiceClient buildServiceClient(){
        APIKeyHolder apiKeyHolder = new APIKeyHolder("YourApiKey","YourSecretKey","passPhrase");

        ApiServiceClient.Builder builder = new ApiServiceClient.Builder().
                apiKeyHolder(apiKeyHolder).
                baseUrl("https://www.okx.com").
                addInterceptor(new AutorizationIntercepter(new OkxHeaderGenerator()));

        ApiServiceClient apiServiceClient = builder.build();
        return apiServiceClient;
    }
    

        //拿到客户端
        ApiServiceClient apiServiceClient = buildServiceClient();
        
        //通过动态代理获得接口的代理对象
        CommonApiService commonApiService = apiServiceClient.create(CommonApiService.class);
        
        //代理对象可以直接拿来用
        String path = "/api/v5/public/time";
        JsonObject result = commonApiService.getExecute(new ParamMap(), "GET",path,JsonObject.class);
        System.out.println(result);

