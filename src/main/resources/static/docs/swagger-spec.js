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
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateEmail486549215"
                },
                "examples" : {
                  "findUser" : {
                    "value" : "input this jwtToken in .http test file : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1YWRiODUzZi1hODFhLTQ3OGEtOTdiYS04MDhkOTgiLCJ1c2VySWQiOiI1YWRiODUzZi1hODFhLTQ3OGEtOTdiYS04MDhkOTgiLCJpYXQiOjE2ODcwMDk0NzIsImV4cCI6MTY4NzAxMTI3Mn0.Ky-ZMpblu2dUc9pSmOE926FR9H96gsAptr_p-drbCBE"
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
                  "value" : "{\r\n  \"email\" : \"abcd0.3757509479875524@naver.com\",\r\n  \"nickName\" : \"abcd\",\r\n  \"password\" : \"abcd1234!\",\r\n  \"emailAuthCode\" : null,\r\n  \"userUUID\" : \"e61bfc74-5405-4086-9be3-b55116\"\r\n}"
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
    "/api/signUp/findDuplicateEmail" : {
      "get" : {
        "tags" : [ "signUp" ],
        "summary" : "find Duplicated Email",
        "description" : "find Duplicated Email",
        "operationId" : "findDuplicateEmail",
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
        "tags" : [ "api" ],
        "summary" : "유저 생성",
        "description" : "유저 생성",
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
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateEmail486549215"
                },
                "examples" : {
                  "findDuplicateNickName" : {
                    "value" : "{\"nickname\":\"abcd1144825\"}"
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
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateEmail486549215"
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
                  "$ref" : "#/components/schemas/api-signUp-findDuplicateEmail486549215"
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
      "api-signUp-findDuplicateEmail486549215" : {
        "type" : "object"
      }
    }
  }
}