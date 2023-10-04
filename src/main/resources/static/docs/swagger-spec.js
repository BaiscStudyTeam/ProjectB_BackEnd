window.swaggerSpec={
  "openapi" : "3.0.1",
  "info" : {
    "title" : "restdocs-swagger API Documentation",
    "description" : "Spring REST Docs with SwaggerUI.",
    "version" : "0.0.1"
  },
  "servers" : [ {
    "url" : "http://13.124.25.59"
  } ],
  "tags" : [ ],
  "paths" : {
    "/api/board/findBoardListByUserId" : {
      "post" : {
        "tags" : [ "board" ],
        "summary" : "find User's board List",
        "description" : "find User's board List",
        "operationId" : "findBoardListByUserId",
        "requestBody" : {
          "content" : {
            "application/json;charset=UTF-8" : {
              "schema" : {
                "$ref" : "#/components/schemas/findBoardListByUserIdDto"
              },
              "examples" : {
                "findBoardListByUserId" : {
                  "value" : "{\"userId\":\"1234\"}"
                }
              }
            }
          }
        },
        "responses" : {
          "200" : {
            "description" : "200",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateNickName486549215"
                },
                "examples" : {
                  "findBoardListByUserId" : {
                    "value" : "[{\"boardId\":\"1234\",\"userId\":\"1234\",\"board_desc\":\"1234\",\"board_thumbnail\":\"1234\",\"regDt\":\"2023-10-03T22:31:22Z\"}]"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/api/comment/findCommentByPostId" : {
      "get" : {
        "tags" : [ "comment" ],
        "summary" : "find User's comments by postId",
        "description" : "find User's comments by postId",
        "operationId" : "findCommentByPostId",
        "parameters" : [ {
          "name" : "postId",
          "in" : "query",
          "description" : "postId to find commentList",
          "required" : true,
          "schema" : {
            "type" : "string"
          }
        } ],
        "responses" : {
          "200" : {
            "description" : "200",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateNickName486549215"
                },
                "examples" : {
                  "findCommentByPostId" : {
                    "value" : "[{\"commentId\":\"1234\",\"postId\":\"1234\",\"commentUserId\":\"1234\",\"commentContent\":\"1234\",\"regDt\":\"2023-10-03T23:53:54Z\"}]"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/api/login/findUser" : {
      "post" : {
        "tags" : [ "login" ],
        "summary" : "login user and give acessToken with HttpOnly cookie",
        "description" : "do login",
        "operationId" : "findUser",
        "requestBody" : {
          "content" : {
            "application/json;charset=UTF-8" : {
              "schema" : {
                "$ref" : "#/components/schemas/LoginReqDto"
              },
              "examples" : {
                "findUser" : {
                  "value" : "{\"email\":\"zaxscd95@gmail.com\",\"password\":\"Abcd1234!\"}"
                }
              }
            }
          }
        },
        "responses" : {
          "200" : {
            "description" : "200",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateNickName486549215"
                },
                "examples" : {
                  "findUser" : {
                    "value" : "{\"email\":\"zaxscd95@gmail.com\",\"nickname\":\"SampleNickname\"}"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/api/login/logoutUser" : {
      "post" : {
        "tags" : [ "login" ],
        "summary" : "logout user",
        "description" : "logout user",
        "operationId" : "logoutUser",
        "responses" : {
          "200" : {
            "description" : "200"
          }
        }
      }
    },
    "/api/login/removeUser" : {
      "delete" : {
        "tags" : [ "signUp" ],
        "summary" : "remove user by email",
        "description" : "remove user",
        "operationId" : "removeUser",
        "requestBody" : {
          "content" : {
            "application/json;charset=UTF-8" : {
              "schema" : {
                "$ref" : "#/components/schemas/RemoveUserReqDto"
              },
              "examples" : {
                "removeUser" : {
                  "value" : "{\"email\":\"zaxscd95@gmail.com\"}"
                }
              }
            }
          }
        },
        "responses" : {
          "200" : {
            "description" : "200"
          }
        }
      }
    },
    "/api/login/updateUser" : {
      "put" : {
        "tags" : [ "login" ],
        "summary" : "update User",
        "description" : "update User Information with nickname and Password",
        "operationId" : "updateUser",
        "requestBody" : {
          "content" : {
            "application/json;charset=UTF-8" : {
              "schema" : {
                "$ref" : "#/components/schemas/UpdateUserReqDto"
              },
              "examples" : {
                "updateUser" : {
                  "value" : "{\"nickname\":\"SampleNickname\",\"password\":\"Abcd1234!\"}"
                }
              }
            }
          }
        },
        "responses" : {
          "200" : {
            "description" : "200"
          }
        }
      }
    },
    "/api/mainPost/findTopPostThumbnailList" : {
      "get" : {
        "tags" : [ "mainPost" ],
        "summary" : "find main Top post list",
        "description" : "find main Top post list",
        "operationId" : "findThumbnailList",
        "responses" : {
          "200" : {
            "description" : "200",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/List<Thumbnail>"
                },
                "examples" : {
                  "findThumbnailList" : {
                    "value" : "[{\"postId\":\"f55c8a02-feb3-4710-bb0a-615fea\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"title\":\"1234\",\"contentSum\":\"1234....\",\"thumbnailImg\":\"1234\",\"regDt\":\"2023-10-04T10:49:18Z\"},{\"postId\":\"1c29a20e-3b99-4830-9c45-a012c6\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"title\":\"1234\",\"contentSum\":\"1234....\",\"thumbnailImg\":\"1234\",\"regDt\":\"2023-10-04T10:42:51Z\"},{\"postId\":\"bc7415c2-528b-4879-b159-00d965\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"title\":\"1234\",\"contentSum\":\"1234....\",\"thumbnailImg\":\"1234\",\"regDt\":\"2023-10-04T10:40:29Z\"}]"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/api/post/findPostByBoardId" : {
      "get" : {
        "tags" : [ "board" ],
        "summary" : "find User's postList by boardId",
        "description" : "find User's postList by boardId",
        "operationId" : "findPostByBoardId",
        "parameters" : [ {
          "name" : "boardId",
          "in" : "query",
          "description" : "boardId to find postList",
          "required" : true,
          "schema" : {
            "type" : "string"
          }
        } ],
        "responses" : {
          "200" : {
            "description" : "200",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/api-post-findPostByBoardId1179184256"
                },
                "examples" : {
                  "findPostByBoardId" : {
                    "value" : "[{\"postId\":\"019d3ee2-42d8-4bce-b3de-b085b3\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-19T06:35:46Z\",\"boardId\":\"default\"},{\"postId\":\"04b1811a-aab3-4918-acd0-7897aa\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:26:28Z\",\"boardId\":\"default\"},{\"postId\":\"0a514870-be27-4197-9ee2-b2bc6c\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-10-04T10:24:38Z\",\"boardId\":\"default\"},{\"postId\":\"1024066a-ff5f-4776-a0d7-a239a9\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-19T06:16:36Z\",\"boardId\":\"default\"},{\"postId\":\"1024ca45-ed08-4b84-95d8-e9bb72\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-21T07:38:03Z\",\"boardId\":\"default\"},{\"postId\":\"115e4ad9-4c5e-4c38-a87b-9e12b6\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-21T07:29:41Z\",\"boardId\":\"default\"},{\"postId\":\"1234\",\"userId\":\"1234\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-17T23:01:17Z\",\"boardId\":\"default\"},{\"postId\":\"12345\",\"userId\":\"1234\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-17T23:20:48Z\",\"boardId\":\"default\"},{\"postId\":\"123456\",\"userId\":\"1234\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-17T23:20:53Z\",\"boardId\":\"default\"},{\"postId\":\"123457\",\"userId\":\"1234\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-17T23:21:01Z\",\"boardId\":\"default\"},{\"postId\":\"14f6d495-989b-4351-ad9c-72bc7b\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-19T06:32:59Z\",\"boardId\":\"default\"},{\"postId\":\"16fc2d89-ec31-40be-9558-9a1ffa\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-21T07:04:19Z\",\"boardId\":\"default\"},{\"postId\":\"17477306-d2e1-4dde-98ce-36866e\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:09:56Z\",\"boardId\":\"default\"},{\"postId\":\"1882b0c0-efe4-49ea-96a3-85e582\",\"userId\":\"slgmgm@naver.com\",\"postTitle\":\"글쓰는 중이에요!!!!\",\"postFile\":null,\"postType\":\"N\",\"regDt\":\"2023-09-09T05:27:58Z\",\"boardId\":\"default\"},{\"postId\":\"1c29a20e-3b99-4830-9c45-a012c6\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-10-04T10:42:51Z\",\"boardId\":\"default\"},{\"postId\":\"1d0a6408-a1f3-41f0-a96a-c97b2a\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"테스트 데이터 제목\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-08-19T08:34:43Z\",\"boardId\":\"default\"},{\"postId\":\"22a8c622-0342-422b-a332-4fd4d9\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-08-26T06:31:46Z\",\"boardId\":\"default\"},{\"postId\":\"27f4600e-0a5a-4e0f-86f3-be7fee\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:04:28Z\",\"boardId\":\"default\"},{\"postId\":\"31e14765-0a59-48f3-be73-d38a31\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-21T07:13:28Z\",\"boardId\":\"default\"},{\"postId\":\"3c27fdec-f38b-4b59-ba48-704d98\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:20:28Z\",\"boardId\":\"default\"},{\"postId\":\"3ef8f5ee-cdcf-431e-b969-4a7a9f\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"테스트111\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-08-20T10:28:49Z\",\"boardId\":\"default\"},{\"postId\":\"48c1ad60-1e22-45f2-8748-89203f\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:32:48Z\",\"boardId\":\"default\"},{\"postId\":\"4bb3adc1-bfbd-4955-a995-c28654\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-10-04T10:24:07Z\",\"boardId\":\"default\"},{\"postId\":\"4dc31f91-7c56-49bf-a09b-62fefa\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-21T07:02:38Z\",\"boardId\":\"default\"},{\"postId\":\"55f77728-68bb-40bc-bf31-a4d2cd\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"테스트 데이터 제목\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-08-20T10:11:15Z\",\"boardId\":\"default\"},{\"postId\":\"576e40a0-7b1d-4dfa-85bc-d564b7\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-19T07:00:31Z\",\"boardId\":\"default\"},{\"postId\":\"5cc7b7e0-6b02-4f42-b4ed-854f88\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-19T06:33:32Z\",\"boardId\":\"default\"},{\"postId\":\"5dbfac72-8fbd-4a3f-ace4-60705a\",\"userId\":\"slgmgm@naver.com\",\"postTitle\":\"123\",\"postFile\":null,\"postType\":\"N\",\"regDt\":\"2023-09-09T02:39:30Z\",\"boardId\":\"default\"},{\"postId\":\"686ca3bf-0afe-4bdf-9c01-2b5554\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-21T07:05:26Z\",\"boardId\":\"default\"},{\"postId\":\"6dbc4a67-85c9-4472-8f22-4fec80\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-08-26T07:24:31Z\",\"boardId\":\"default\"},{\"postId\":\"71540d44-9e63-4977-ba9a-76d759\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:27:23Z\",\"boardId\":\"default\"},{\"postId\":\"7616fea6-ad10-4251-a025-64df52\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-10-04T10:30:48Z\",\"boardId\":\"default\"},{\"postId\":\"78a80df5-c71f-433f-8d9b-1b7fc2\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-21T06:57:12Z\",\"boardId\":\"default\"},{\"postId\":\"7a35f539-3437-4a72-9d22-104263\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-08-18T17:50:06Z\",\"boardId\":\"default\"},{\"postId\":\"8b49acc3-3042-41ca-9c9c-07a429\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"테스트 데이터 제목\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-08-20T08:44:07Z\",\"boardId\":\"default\"},{\"postId\":\"8d508f46-8412-4349-99f3-c52f13\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:30:24Z\",\"boardId\":\"default\"},{\"postId\":\"935e0fc3-f0ca-4da3-a559-cf9b07\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:18:08Z\",\"boardId\":\"default\"},{\"postId\":\"97bb75a4-2399-4c60-9118-540d8d\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:19:26Z\",\"boardId\":\"default\"},{\"postId\":\"9ad0e79b-ec99-4c51-ab69-9305f8\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"ㅎㅎㅎㅎㅎ\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-08-25T06:41:12Z\",\"boardId\":\"default\"},{\"postId\":\"b2d7bb8d-4fcf-4a2e-8d17-498849\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:06:13Z\",\"boardId\":\"default\"},{\"postId\":\"b56a4baf-211c-4f39-9c8d-1b0d92\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-21T06:52:48Z\",\"boardId\":\"default\"},{\"postId\":\"bc7415c2-528b-4879-b159-00d965\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-10-04T10:40:29Z\",\"boardId\":\"default\"},{\"postId\":\"bd696c63-5e21-4a12-b6d5-db4720\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-19T08:20:06Z\",\"boardId\":\"default\"},{\"postId\":\"bd78fb04-8209-42e9-81e8-d22f04\",\"userId\":\"slgmgm@naver.com\",\"postTitle\":\"글제목입니다~\",\"postFile\":null,\"postType\":\"N\",\"regDt\":\"2023-09-17T05:38:48Z\",\"boardId\":\"default\"},{\"postId\":\"bf28cfba-fbaf-4b05-84f7-7b6039\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-10-04T10:25:03Z\",\"boardId\":\"default\"},{\"postId\":\"c11e2a99-2dc0-48e6-9240-5e440d\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:32:17Z\",\"boardId\":\"default\"},{\"postId\":\"c336e445-9959-464f-a23f-62fa21\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-10-04T07:13:17Z\",\"boardId\":\"default\"},{\"postId\":\"c4725699-7d7b-4319-8845-a284d3\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T10:00:16Z\",\"boardId\":\"default\"},{\"postId\":\"c87b4702-aca9-4d9e-a0a6-0bac06\",\"userId\":\"slgmgm@naver.com\",\"postTitle\":\"test22\",\"postFile\":null,\"postType\":\"N\",\"regDt\":\"2023-09-09T02:40:44Z\",\"boardId\":\"default\"},{\"postId\":\"c99d1bf3-97ee-4d83-a603-636c46\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-21T07:12:37Z\",\"boardId\":\"default\"},{\"postId\":\"c9f6388e-d749-4a26-8b90-9a3996\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-21T07:11:18Z\",\"boardId\":\"default\"},{\"postId\":\"cb562d68-b41e-48c5-a43f-d1ae47\",\"userId\":\"zaxscd95@gmail.com\",\"postTitle\":\"21323123123123\",\"postFile\":null,\"postType\":\"N\",\"regDt\":\"2023-09-24T08:48:42Z\",\"boardId\":\"default\"},{\"postId\":\"ce017024-4782-424c-836c-c868e3\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:39:32Z\",\"boardId\":\"default\"},{\"postId\":\"d6da27a6-eb60-45fe-a392-3fb64e\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-21T06:46:26Z\",\"boardId\":\"default\"},{\"postId\":\"d8111fb3-a23a-40ce-867f-922160\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"테스트 데이터 제목\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-08-19T10:25:21Z\",\"boardId\":\"default\"},{\"postId\":\"dc4b45b3-0178-4afe-8edd-d53a41\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:25:33Z\",\"boardId\":\"default\"},{\"postId\":\"dd3e46b2-f070-4339-8bf8-b4e1e3\",\"userId\":\"slgmgm@naver.com\",\"postTitle\":\"글제목!\",\"postFile\":null,\"postType\":\"N\",\"regDt\":\"2023-09-17T05:40:46Z\",\"boardId\":\"default\"},{\"postId\":\"e4fede18-b8b7-4a77-a754-e4bbbb\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-21T07:18:02Z\",\"boardId\":\"default\"},{\"postId\":\"e6bc1c81-ff57-443e-9357-d1d524\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:26:51Z\",\"boardId\":\"default\"},{\"postId\":\"ecaf4422-664a-425c-acfe-93b346\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:23:52Z\",\"boardId\":\"default\"},{\"postId\":\"ed40e978-f1ab-4078-81b1-84247c\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-21T06:56:36Z\",\"boardId\":\"default\"},{\"postId\":\"f2f731c7-1fe6-4f61-9aa3-8b4131\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:30:03Z\",\"boardId\":\"default\"},{\"postId\":\"f55c8a02-feb3-4710-bb0a-615fea\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-10-04T10:49:18Z\",\"boardId\":\"default\"},{\"postId\":\"f9e38ca8-0c8a-4240-b4b1-e4b83f\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:29:42Z\",\"boardId\":\"default\"},{\"postId\":\"fa17969d-aa94-4801-9be1-2f6a9d\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T09:33:40Z\",\"boardId\":\"default\"},{\"postId\":\"fbbcdccf-0f6d-4a3f-aa71-614c53\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-10-04T10:50:15Z\",\"boardId\":\"default\"},{\"postId\":\"ffce1ffd-5d9c-48ae-b305-018b58\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-18T08:59:10Z\",\"boardId\":\"default\"}]"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/api/post/findPostByPostId" : {
      "get" : {
        "tags" : [ "board" ],
        "summary" : "find User's post detail by postId",
        "description" : "find User's post detail by postId",
        "operationId" : "findPostByPostId",
        "parameters" : [ {
          "name" : "postId",
          "in" : "query",
          "description" : "postId to find post Detail",
          "required" : true,
          "schema" : {
            "type" : "string"
          }
        } ],
        "responses" : {
          "200" : {
            "description" : "200",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/api-post-findPostByPostId-212261113"
                },
                "examples" : {
                  "findPostByPostId" : {
                    "value" : "{\"postId\":\"1234\",\"userId\":\"1234\",\"postTitle\":\"1234\",\"postFile\":\"1234\",\"postType\":\"N\",\"regDt\":\"2023-06-17T23:01:17Z\",\"boardId\":\"default\"}"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/api/post/savePost" : {
      "put" : {
        "tags" : [ "post" ],
        "summary" : "save User's post",
        "description" : "save User's post",
        "operationId" : "savePost",
        "requestBody" : {
          "content" : {
            "application/json;charset=UTF-8" : {
              "schema" : {
                "$ref" : "#/components/schemas/SavePostReqDto"
              },
              "examples" : {
                "savePost" : {
                  "value" : "{\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"postTitle\":\"1234\",\"postType\":\"N\",\"postFile\":\"1234\",\"content\":\"example-Conetent\",\"contentSum\":\"1234....\",\"thumbnailImg\":\"1234\",\"regDt\":\"2018-12-15T10:00:00\",\"zoneId\":\"KOR\"}"
                }
              }
            }
          }
        },
        "responses" : {
          "200" : {
            "description" : "200"
          }
        }
      }
    },
    "/api/signUp/findDuplicateEmail" : {
      "get" : {
        "tags" : [ "signUp" ],
        "summary" : "find Duplicate email",
        "description" : "find Duplicate email",
        "operationId" : "findDuplicateEmail",
        "parameters" : [ {
          "name" : "email",
          "in" : "query",
          "description" : "email",
          "required" : true,
          "schema" : {
            "type" : "string"
          }
        } ],
        "responses" : {
          "200" : {
            "description" : "200",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateNickName486549215"
                },
                "examples" : {
                  "findDuplicateEmail" : {
                    "value" : "1"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/api/signUp/findDuplicateNickName" : {
      "get" : {
        "tags" : [ "signUp" ],
        "summary" : "find Duplicate Nickname and if it is duplicate, give new Nickname",
        "description" : "find Duplicate NickName",
        "operationId" : "findDuplicateNickName",
        "parameters" : [ {
          "name" : "nickname",
          "in" : "query",
          "description" : "nickname",
          "required" : true,
          "schema" : {
            "type" : "string"
          }
        } ],
        "responses" : {
          "200" : {
            "description" : "200",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateNickName486549215"
                },
                "examples" : {
                  "findDuplicateNickName" : {
                    "value" : "{\"nickname\":\"abcde569\"}"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/api/signUp/sendVarificationEmail" : {
      "post" : {
        "tags" : [ "signUp" ],
        "summary" : "send Varification Email",
        "description" : "send Varification Email",
        "operationId" : "sendVarificationEmail",
        "requestBody" : {
          "content" : {
            "application/json;charset=UTF-8" : {
              "schema" : {
                "$ref" : "#/components/schemas/SendVarificationEmailReqDto"
              },
              "examples" : {
                "sendVarificationEmail" : {
                  "value" : "{\"email\":\"zaxscd95@gmail.com\"}"
                }
              }
            }
          }
        },
        "responses" : {
          "200" : {
            "description" : "200",
            "content" : {
              "text/plain;charset=UTF-8" : {
                "schema" : {
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateNickName486549215"
                },
                "examples" : {
                  "sendVarificationEmail" : {
                    "value" : "4cc067b4-6a87-471b-96b3-1d6538"
                  }
                }
              }
            }
          }
        }
      }
    }
  },
  "components" : {
    "schemas" : {
      "findBoardListByUserIdDto" : {
        "title" : "findBoardListByUserIdDto",
        "type" : "object",
        "properties" : {
          "userId" : {
            "type" : "string",
            "description" : "UserId for post input"
          }
        }
      },
      "RemoveUserReqDto" : {
        "title" : "RemoveUserReqDto",
        "type" : "object",
        "properties" : {
          "email" : {
            "type" : "string",
            "description" : "Email to find remove User"
          }
        }
      },
      "api-post-findPostByBoardId1179184256" : {
        "type" : "array",
        "items" : {
          "type" : "object",
          "properties" : {
            "regDt" : {
              "type" : "string",
              "description" : "post registered date"
            },
            "postFile" : {
              "type" : "string",
              "description" : "post content Summary"
            },
            "postType" : {
              "type" : "string",
              "description" : "post thumbnail uri"
            },
            "boardId" : {
              "type" : "string",
              "description" : "post's board id"
            },
            "postTitle" : {
              "type" : "string",
              "description" : "post title"
            },
            "postId" : {
              "type" : "string",
              "description" : "post Id"
            },
            "userId" : {
              "type" : "string",
              "description" : "post's regist userId"
            }
          }
        }
      },
      "SavePostReqDto" : {
        "title" : "SavePostReqDto",
        "type" : "object",
        "properties" : {
          "regDt" : {
            "type" : "string",
            "description" : "regDt for post input"
          },
          "postFile" : {
            "type" : "string",
            "description" : "postFile for post input"
          },
          "postType" : {
            "type" : "string",
            "description" : "postType for post input"
          },
          "contentSum" : {
            "type" : "string",
            "description" : "content Summary for post input"
          },
          "zoneId" : {
            "type" : "string",
            "description" : "ZoneId for post input"
          },
          "postTitle" : {
            "type" : "string",
            "description" : "postTitle for post input"
          },
          "thumbnailImg" : {
            "type" : "string",
            "description" : "thumbnail img uri for post input"
          },
          "userId" : {
            "type" : "string",
            "description" : "UserId for post input"
          },
          "content" : {
            "type" : "string",
            "description" : "content for post input"
          }
        }
      },
      "List<Thumbnail>" : {
        "title" : "List<Thumbnail>",
        "type" : "array",
        "items" : {
          "type" : "object",
          "properties" : {
            "regDt" : {
              "type" : "string",
              "description" : "top post registered date"
            },
            "contentSum" : {
              "type" : "string",
              "description" : "top post content Summary"
            },
            "thumbnailImg" : {
              "type" : "string",
              "description" : "top post thumbnail uri"
            },
            "postId" : {
              "type" : "string",
              "description" : "top Post Id"
            },
            "title" : {
              "type" : "string",
              "description" : "top post title"
            },
            "userId" : {
              "type" : "string",
              "description" : "top post's regist userId"
            }
          }
        }
      },
      "api-post-findPostByPostId-212261113" : {
        "type" : "object",
        "properties" : {
          "regDt" : {
            "type" : "string",
            "description" : "post registered date"
          },
          "postFile" : {
            "type" : "string",
            "description" : "post content Summary"
          },
          "postType" : {
            "type" : "string",
            "description" : "post thumbnail uri"
          },
          "boardId" : {
            "type" : "string",
            "description" : "post's board id"
          },
          "postTitle" : {
            "type" : "string",
            "description" : "post title"
          },
          "postId" : {
            "type" : "string",
            "description" : "post Id"
          },
          "userId" : {
            "type" : "string",
            "description" : "post's regist userId"
          }
        }
      },
      "LoginReqDto" : {
        "title" : "LoginReqDto",
        "type" : "object",
        "properties" : {
          "password" : {
            "type" : "string",
            "description" : "Password of the user"
          },
          "email" : {
            "type" : "string",
            "description" : "Email of the user"
          }
        }
      },
      "UpdateUserReqDto" : {
        "title" : "UpdateUserReqDto",
        "type" : "object",
        "properties" : {
          "password" : {
            "type" : "string",
            "description" : "Password to change"
          },
          "nickname" : {
            "type" : "string",
            "description" : "nickname to change"
          }
        }
      },
      "api-signUp-findDuplicateNickName486549215" : {
        "type" : "object"
      },
      "SendVarificationEmailReqDto" : {
        "title" : "SendVarificationEmailReqDto",
        "type" : "object",
        "properties" : {
          "email" : {
            "type" : "string",
            "description" : "Email to send Authentication code"
          }
        }
      }
    }
  }
}