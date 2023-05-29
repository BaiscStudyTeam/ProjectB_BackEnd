window.swaggerSpec={
  "openapi" : "3.0.1",
  "info" : {
    "title" : "RestDocs to Swagger 변환 테스트",
    "description" : "Restdocs로 API 문서 작성 후 이를 Swagger로 변환하는 페이지",
    "version" : "0.0.1-SNAPSHOT"
  },
  "servers" : [ {
    "url" : "http://ec2-3-36-99-194.ap-northeast-2.compute.amazonaws.com:8080"
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
                  "$ref" : "#/components/schemas/api-login-findUser486549215"
                },
                "examples" : {
                  "findUser" : {
                    "value" : "input this jwtToken in .http test file : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ6YXhzY2Q5NUBuYXZlci5jb20iLCJ1c2VyUGsiOiJ6YXhzY2Q5NUBuYXZlci5jb20iLCJuaWNrTmFtZSI6ImRsZGJ0aGQxIiwiaWF0IjoxNjg1MzkwNjg4LCJleHAiOjE2ODUzOTI0ODh9.2YYnHs-S0VW7b-lKaqPyLNnDqufAzQ0DYtqJFztxiuk"
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
        "operationId" : "removeUser",
        "requestBody" : {
          "content" : {
            "application/json;charset=UTF-8" : {
              "schema" : {
                "$ref" : "#/components/schemas/RemoveUserReqDto.email"
              },
              "examples" : {
                "removeUser" : {
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
                  "$ref" : "#/components/schemas/api-login-findUser486549215"
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
                  "value" : "{\r\n  \"email\" : \"abcd0.44732435069361165@naver.com\",\r\n  \"nickName\" : \"abcd\",\r\n  \"password\" : \"abcd1234!\",\r\n  \"userUUID\" : \"8b6114b8-4553-4d47-9b9c-35a4ca\"\r\n}"
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
                  "$ref" : "#/components/schemas/api-login-findUser486549215"
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
                  "$ref" : "#/components/schemas/api-login-findUser486549215"
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
                "$ref" : "#/components/schemas/SendVarificationEmailReqDto.email"
              },
              "examples" : {
                "sendVarificationEmail" : {
                  "value" : "{\r\n  \"email\" : \"zaxscd95@gmail.com\"\r\n}"
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
                  "$ref" : "#/components/schemas/api-login-findUser486549215"
                },
                "examples" : {
                  "sendVarificationEmail" : {
                    "value" : "your account has been created. go to address \\home.html"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/api/signUp/checkEmailCode/9b08af2d-44c5-4bf3-8072-b4b771" : {
      "get" : {
        "tags" : [ "signUp" ],
        "summary" : "send Varification redis",
        "description" : "check Varification code in redis. usually it add to Mail Content URL Path Variable.",
        "operationId" : "checkEmailCode",
        "responses" : {
          "200" : {
            "description" : "200",
            "content" : {
              "text/plain;charset=UTF-8" : {
                "schema" : {
                  "$ref" : "#/components/schemas/api-login-findUser486549215"
                },
                "examples" : {
                  "checkEmailCode" : {
                    "value" : "your email code is expired or not exist. please send Varification Email Again"
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
      "SendVarificationEmailReqDto.email" : {
        "title" : "SendVarificationEmailReqDto.email",
        "type" : "object"
      },
      "api-login-findUser486549215" : {
        "type" : "object"
      }
    }
  }
}