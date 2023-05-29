window.swaggerSpec={
  "openapi" : "3.0.1",
  "info" : {
    "title" : "RestDocs to Swagger 변환 테스트",
    "description" : "Restdocs로 API 문서 작성 후 이를 Swagger로 변환하는 페이지",
    "version" : "0.0.1-SNAPSHOT"
  },
  "servers" : [ {
    "url" : "http://localhost:8080"
  } ],
  "tags" : [ ],
  "paths" : {
    "/api/login/findUser" : {
      "get" : {
        "tags" : [ "login" ],
        "summary" : "user Login function",
        "description" : "when user login, give user JwtToken sample to test",
        "operationId" : "findUser",
        "responses" : {
          "200" : {
            "description" : "200",
            "content" : {
              "text/plain;charset=UTF-8" : {
                "schema" : {
                  "$ref" : "#/components/schemas/api-login-removeUser486549215"
                },
                "examples" : {
                  "findUser" : {
                    "value" : "input this jwtToken in .http test file : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ6YXhzY2Q5NUBuYXZlci5jb20iLCJ1c2VyUGsiOiJ6YXhzY2Q5NUBuYXZlci5jb20iLCJuaWNrTmFtZSI6Im1hbWFtYW0iLCJpYXQiOjE2ODUzMzI5ODAsImV4cCI6MTY4NTMzNDc4MH0.sEdngqPX96Jwz7YsCpP9NORaDqY4N9dbrU6xpS9C2fY"
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
        "tags" : [ "login" ],
        "summary" : "remove User Test",
        "description" : "remove user",
        "operationId" : "test-get",
        "requestBody" : {
          "content" : {
            "application/json;charset=UTF-8" : {
              "schema" : {
                "$ref" : "#/components/schemas/RemoveUserReqDto.email"
              },
              "examples" : {
                "test-get" : {
                  "value" : "{\r\n  \"email\" : \"zaxscd95@naver.com\"\r\n}"
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
                  "$ref" : "#/components/schemas/api-login-removeUser486549215"
                },
                "examples" : {
                  "test-get" : {
                    "value" : "your account info removed."
                  }
                }
              }
            }
          }
        }
      }
    },
    "/api/login/saveUser" : {
      "post" : {
        "tags" : [ "login" ],
        "summary" : "save User test",
        "description" : "save User's email, password, nickname",
        "operationId" : "saveUser",
        "requestBody" : {
          "content" : {
            "application/json;charset=UTF-8" : {
              "schema" : {
                "$ref" : "#/components/schemas/InsertUserReqDto.nickname"
              },
              "examples" : {
                "saveUser" : {
                  "value" : "{\r\n  \"email\" : \"abcd0.0867364442590548@naver.com\",\r\n  \"nickName\" : \"abcd\",\r\n  \"password\" : \"abcd1234!\",\r\n  \"userUUID\" : \"56b840d6-8da5-4eea-a783-4ef3e6\"\r\n}"
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
                  "$ref" : "#/components/schemas/api-login-removeUser486549215"
                },
                "examples" : {
                  "saveUser" : {
                    "value" : "your account has been created. go to address \\home.html"
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
        "summary" : "update User test",
        "description" : "update User Information",
        "operationId" : "updateUser",
        "requestBody" : {
          "content" : {
            "application/json;charset=UTF-8" : {
              "schema" : {
                "$ref" : "#/components/schemas/UpdateUserReqDto.email"
              },
              "examples" : {
                "updateUser" : {
                  "value" : "{\r\n  \"email\" : \"zaxscd95@naver.com\"\r\n}"
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
                  "$ref" : "#/components/schemas/api-login-removeUser486549215"
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
    }
  },
  "components" : {
    "schemas" : {
      "InsertUserReqDto.nickname" : {
        "title" : "InsertUserReqDto.nickname",
        "type" : "object"
      },
      "UpdateUserReqDto.email" : {
        "title" : "UpdateUserReqDto.email",
        "type" : "object"
      },
      "RemoveUserReqDto.email" : {
        "title" : "RemoveUserReqDto.email",
        "type" : "object"
      },
      "api-login-removeUser486549215" : {
        "type" : "object"
      }
    }
  }
}