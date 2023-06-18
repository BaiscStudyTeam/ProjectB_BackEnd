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
      "post" : {
        "tags" : [ "login" ],
        "summary" : "user Login function",
        "description" : "when user login, give user JwtToken sample to test",
        "operationId" : "findUser",
        "requestBody" : {
          "content" : {
            "application/json;charset=UTF-8" : {
              "schema" : {
                "$ref" : "#/components/schemas/LoginReqDto.password"
              },
              "examples" : {
                "findUser" : {
                  "value" : "{\r\n  \"email\" : \"zaxscd95@naver.com\",\r\n  \"password\" : \"5555\"\r\n}"
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
                  "$ref" : "#/components/schemas/api-login-updateUser486549215"
                },
                "examples" : {
                  "findUser" : {
                    "value" : "input this jwtToken in .http test file : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1YWRiODUzZi1hODFhLTQ3OGEtOTdiYS04MDhkOTgiLCJ1c2VySWQiOiI1YWRiODUzZi1hODFhLTQ3OGEtOTdiYS04MDhkOTgiLCJpYXQiOjE2ODcwODA4MjAsImV4cCI6MTY4NzA4MjYyMH0.Zxx_PSJ9-tqeLGhYoufVnAf9aDlrMdXivCJAZGiQ20s"
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
                  "$ref" : "#/components/schemas/api-login-updateUser486549215"
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
                  "value" : "{\r\n  \"nickname\" : \"7777\",\r\n  \"password\" : \"5555\"\r\n}"
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
                  "$ref" : "#/components/schemas/api-login-updateUser486549215"
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
        "tags" : [ "post" ],
        "summary" : "find post list",
        "description" : "find post list",
        "operationId" : "findThumbnailList",
        "responses" : {
          "200" : {
            "description" : "200",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/api-login-updateUser486549215"
                },
                "examples" : {
                  "findThumbnailList" : {
                    "value" : "[ {\r\n  \"postId\" : \"fa17969d-aa94-4801-9be1-2f6a9d\",\r\n  \"userId\" : \"5394e39b-a863-427d-8121-1a7e69\",\r\n  \"title\" : \"1234\",\r\n  \"contentSum\" : \"1234....\",\r\n  \"thumbnailImg\" : \"1234\",\r\n  \"regDt\" : \"2023-06-18T09:33:40.000+00:00\"\r\n}, {\r\n  \"postId\" : \"48c1ad60-1e22-45f2-8748-89203f\",\r\n  \"userId\" : \"5394e39b-a863-427d-8121-1a7e69\",\r\n  \"title\" : \"1234\",\r\n  \"contentSum\" : \"1234....\",\r\n  \"thumbnailImg\" : \"1234\",\r\n  \"regDt\" : \"2023-06-18T09:32:48.000+00:00\"\r\n}, {\r\n  \"postId\" : \"c11e2a99-2dc0-48e6-9240-5e440d\",\r\n  \"userId\" : \"5394e39b-a863-427d-8121-1a7e69\",\r\n  \"title\" : \"1234\",\r\n  \"contentSum\" : \"1234....\",\r\n  \"thumbnailImg\" : \"1234\",\r\n  \"regDt\" : \"2023-06-18T09:32:17.000+00:00\"\r\n} ]"
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
        "summary" : "save post list",
        "description" : "save post list",
        "operationId" : "savePost",
        "requestBody" : {
          "content" : {
            "application/json;charset=UTF-8" : {
              "schema" : {
                "$ref" : "#/components/schemas/api-login-updateUser486549215"
              },
              "examples" : {
                "savePost" : {
                  "value" : "{\r\n  \"userId\" : \"5394e39b-a863-427d-8121-1a7e69\",\r\n  \"postTitle\" : \"1234\",\r\n  \"postType\" : \"N\",\r\n  \"postFile\" : \"1234\",\r\n  \"content\" : \"1111111111111\",\r\n  \"contentSum\" : \"1234....\",\r\n  \"thumbnailImg\" : \"1234\",\r\n  \"regDt\" : 1687080819762\r\n}"
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
                  "$ref" : "#/components/schemas/api-login-updateUser486549215"
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
                  "$ref" : "#/components/schemas/api-login-updateUser486549215"
                },
                "examples" : {
                  "findDuplicateNickName" : {
                    "value" : "{\"nickname\":\"abcd8711791\"}"
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
                  "value" : "{\r\n  \"email\" : \"zaxscd951444456@gmail.com\",\r\n  \"nickName\" : \"abcd\",\r\n  \"password\" : \"abcd1234!\",\r\n  \"emailAuthCode\" : \"384a475f-6150-49cf-aaa6-0eafe4\",\r\n  \"userUUID\" : \"5173b2e6-a0b7-4238-b6e1-9fc7b6\"\r\n}"
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
                  "$ref" : "#/components/schemas/api-login-updateUser486549215"
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
                  "value" : "{\r\n  \"email\" : \"zaxscd15@gmail.com\"\r\n}"
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
                  "$ref" : "#/components/schemas/api-login-updateUser486549215"
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
                  "$ref" : "#/components/schemas/api-login-updateUser486549215"
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
      "LoginReqDto.password" : {
        "title" : "LoginReqDto.password",
        "type" : "object"
      },
      "api-login-updateUser486549215" : {
        "type" : "object"
      }
    }
  }
}