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
              "application/json;charset=UTF-8" : {
                "schema" : {
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateEmail486549215"
                },
                "examples" : {
                  "findUser" : {
                    "value" : "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0Zjk3NTZhMS1lYTgwLTQwZmMtYjdiZi1iMTZkZTAiLCJ1c2VySWQiOiI0Zjk3NTZhMS1lYTgwLTQwZmMtYjdiZi1iMTZkZTAiLCJpYXQiOjE2ODczMzMwNzYsImV4cCI6MTY4NzMzNDg3Nn0.ixltCqC-E4W5M7NPKSlCaAOJ8v-AZSIT6VupqPh_K54"
                  }
                }
              }
            }
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
            "description" : "200",
            "content" : {
              "text/plain;charset=UTF-8" : {
                "schema" : {
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateEmail486549215"
                },
                "examples" : {
                  "removeUser" : {
                    "value" : "your account info removed."
                  }
                }
              }
            }
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
        "parameters" : [ {
          "name" : "X-AUTH-TOKEN",
          "in" : "header",
          "description" : "accessToken header for login User",
          "required" : true,
          "schema" : {
            "type" : "string"
          },
          "example" : "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0Zjk3NTZhMS1lYTgwLTQwZmMtYjdiZi1iMTZkZTAiLCJ1c2VySWQiOiI0Zjk3NTZhMS1lYTgwLTQwZmMtYjdiZi1iMTZkZTAiLCJpYXQiOjE2ODczMzMwNzYsImV4cCI6MTY4NzMzNDg3Nn0.ixltCqC-E4W5M7NPKSlCaAOJ8v-AZSIT6VupqPh_K54"
        } ],
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
            "description" : "200",
            "content" : {
              "text/plain;charset=UTF-8" : {
                "schema" : {
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateEmail486549215"
                },
                "examples" : {
                  "updateUser" : {
                    "value" : "your account info updated."
                  }
                }
              }
            }
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
                    "value" : "[{\"postId\":\"115e4ad9-4c5e-4c38-a87b-9e12b6\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"title\":\"1234\",\"contentSum\":\"1234....\",\"thumbnailImg\":\"1234\",\"regDt\":\"2023-06-21T07:29:41Z\"},{\"postId\":\"e4fede18-b8b7-4a77-a754-e4bbbb\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"title\":\"1234\",\"contentSum\":\"1234....\",\"thumbnailImg\":\"1234\",\"regDt\":\"2023-06-21T07:18:02Z\"},{\"postId\":\"31e14765-0a59-48f3-be73-d38a31\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"title\":\"1234\",\"contentSum\":\"1234....\",\"thumbnailImg\":\"1234\",\"regDt\":\"2023-06-21T07:13:28Z\"}]"
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
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateEmail486549215"
                },
                "examples" : {
                  "findDuplicateEmail" : {
                    "value" : "0"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/api/signUp/saveUser" : {
      "post" : {
        "tags" : [ "signUp" ],
        "summary" : "save User",
        "description" : "save User",
        "operationId" : "findDuplicateNickName",
        "requestBody" : {
          "content" : {
            "application/json;charset=UTF-8" : {
              "schema" : {
                "$ref" : "#/components/schemas/InsertUserReqDto"
              },
              "examples" : {
                "findDuplicateNickName" : {
                  "value" : "{\"email\":\"zaxscd95@gmail.com\",\"nickName\":\"abcd\",\"password\":\"abcd1234!\",\"emailAuthCode\":\"0a55de9f-86a4-428c-bbb0-079865\"}"
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
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateEmail486549215"
                },
                "examples" : {
                  "findDuplicateNickName" : {
                    "value" : "your account has been created. go to address \\home.html"
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
                    "value" : "[{\"postId\":\"115e4ad9-4c5e-4c38-a87b-9e12b6\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"title\":\"1234\",\"contentSum\":\"1234....\",\"thumbnailImg\":\"1234\",\"regDt\":\"2023-06-21T07:29:41Z\"},{\"postId\":\"e4fede18-b8b7-4a77-a754-e4bbbb\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"title\":\"1234\",\"contentSum\":\"1234....\",\"thumbnailImg\":\"1234\",\"regDt\":\"2023-06-21T07:18:02Z\"},{\"postId\":\"31e14765-0a59-48f3-be73-d38a31\",\"userId\":\"5394e39b-a863-427d-8121-1a7e69\",\"title\":\"1234\",\"contentSum\":\"1234....\",\"thumbnailImg\":\"1234\",\"regDt\":\"2023-06-21T07:13:28Z\"}]"
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
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateEmail486549215"
                },
                "examples" : {
                  "sendVarificationEmail" : {
                    "value" : "0a55de9f-86a4-428c-bbb0-079865"
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
      "InsertUserReqDto" : {
        "title" : "InsertUserReqDto",
        "type" : "object",
        "properties" : {
          "password" : {
            "type" : "string",
            "description" : "Email to find remove User"
          },
          "nickName" : {
            "type" : "string",
            "description" : "Email to find remove User"
          },
          "emailAuthCode" : {
            "type" : "string",
            "description" : "Email to find remove User"
          },
          "email" : {
            "type" : "string",
            "description" : "Email to find remove User"
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
      "api-signUp-findDuplicateEmail486549215" : {
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
      }
    }
  }
}