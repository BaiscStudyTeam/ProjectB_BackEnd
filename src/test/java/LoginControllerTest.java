import com.epages.restdocs.apispec.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.objeto.SpringBootApplicationMain;
import com.objeto.board.dto.request.findBoardListByUserIdDtoTest;
import com.objeto.login.dto.request.FindUserReqDto;
import com.objeto.login.dto.request.InsertUserReqDto;
import com.objeto.login.dto.request.RemoveUserReqDto;
import com.objeto.login.dto.request.UpdateUserReqDto;
import com.objeto.post.dto.request.SavePostReqDtoTest;
import com.objeto.signup.dto.request.SendVarificationEmailReqDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.headers.HeaderDescriptor;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SpringBootApplicationMain.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    private static String accessTokenValue;

    private static String emailauthCode;

    @Order(1)
    @Test
    @DisplayName("POST:api/login/findUser")
    void loginUserTest() throws Exception {

        FindUserReqDto dto = FindUserReqDto.builder()
                .email("zaxscd95@gmail.com")
                .password("Abcd1234!")
                .build();

        ResultActions actions = mockMvc.perform(RestDocumentationRequestBuilders.post("/api/login/findUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("findUser",
                        ResourceDocumentation.resource(
                                ResourceSnippetParameters.builder()
                                        .tag("login").description("do login")
                                        .summary("login user and give acessToken with HttpOnly cookie")
                                        .requestSchema(Schema.schema("LoginReqDto"))
                                        .requestFields(
                                                fieldWithPath("email").description("Email of the user").type(JsonFieldType.STRING),
                                                fieldWithPath("password").description("Password of the user").type(JsonFieldType.STRING)
                                        )
                                        .build()
                        )
                     )
                );
        // Set token for Next updateUser value
        accessTokenValue = actions.andReturn().getResponse().getCookie("authentication").getValue();
        System.out.println(actions.andReturn().getResponse().getContentAsString());

    }

    @Order(2)
    @Test
    @DisplayName("PUT:api/login/updateUser")
    void modifyUserTest() throws Exception {

        UpdateUserReqDto dto = UpdateUserReqDto.builder().nickname("SampleNickname").password("Abcd1234!").build();
        mockMvc.perform(RestDocumentationRequestBuilders.put("/api/login/updateUser")
                        // Need Jwt Token that findUser method provide
                        .header("X-AUTH-TOKEN", accessTokenValue)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("updateUser",
                        ResourceDocumentation.resource(
                                ResourceSnippetParameters.builder()
                                        .tag("login").summary("update User")
                                        .description("update User Information with nickname and Password")
                                        .requestSchema(Schema.schema("UpdateUserReqDto"))
                                        .requestHeaders(
                                                new HeaderDescriptorWithType("X-AUTH-TOKEN").description("accessToken header for login User").type(SimpleType.STRING)
                                        )
                                        .requestFields(
                                                fieldWithPath("nickname").description("nickname to change").type(JsonFieldType.STRING),
                                                fieldWithPath("password").description("Password to change").type(JsonFieldType.STRING)
                                        )
                                        .build()
                        )
                    )
                );

    }

    @Order(3)
    @Test
    @DisplayName("POST:api/signIn/sendVarificationEmail")
    void sendVarificationEmail() throws Exception {

        SendVarificationEmailReqDto dto = SendVarificationEmailReqDto.builder().email("zaxscd95@gmail.com").build();
        ResultActions actions = mockMvc.perform(RestDocumentationRequestBuilders.post("/api/signUp/sendVarificationEmail")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("sendVarificationEmail",
                        ResourceDocumentation.resource(
                                ResourceSnippetParameters.builder()
                                        .tag("signUp").summary("send Varification Email")
                                        .description("send Varification Email")
                                        .requestSchema(Schema.schema("SendVarificationEmailReqDto"))
                                        .requestFields(
                                                fieldWithPath("email").description("Email to send Authentication code").type(JsonFieldType.STRING)
                                        )
                                        .build()
                        )
                ));
        // Set token for Next updateUser value
        emailauthCode = actions.andReturn().getResponse().getContentAsString();
        System.out.println(actions.andReturn().getResponse().getContentAsString());
    }

    @Order(4)
    @Test
    @DisplayName("DELETE:api/login/removeUser")
    void removeUserTest() throws Exception {

        RemoveUserReqDto dto = RemoveUserReqDto.builder().email("zaxscd95@gmail.com").build();
        mockMvc.perform(RestDocumentationRequestBuilders.delete("/api/login/removeUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("removeUser",
                        ResourceDocumentation.resource(
                                ResourceSnippetParameters.builder()
                                        .tag("signUp").description("remove user")
                                        .summary("remove user by email")
                                        .requestSchema(Schema.schema("RemoveUserReqDto"))
                                        .requestFields(
                                                fieldWithPath("email").description("Email to find remove User").type(JsonFieldType.STRING)
                                        )
                                        .build()
                        )
                ));



    }

    @Order(5)
    @Test
    @DisplayName("GET:api/signUp/findDuplicateEmail")
    void findDuplicateEmail() throws Exception {

        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/signUp/findDuplicateEmail?email=" + "zaxscd95@gmail.com"))
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("findDuplicateEmail",
                        ResourceDocumentation.resource(
                                ResourceSnippetParameters.builder()
                                        .tag("signUp")
                                        .description("find Duplicate email")
                                        .summary("find Duplicate email")
                                        .queryParameters(
                                                parameterWithName("email").description("email")
                                        )
                                        .build()
                        )
                ));
    }


    @Order(6)
    @Test
    @DisplayName("GET:api/signUp/findDuplicateNickName")
    void findDuplicateNickName() throws Exception {
        //make Test Request
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/signUp/findDuplicateNickName?nickname=" + "abcd" + Math.random()))
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("findDuplicateNickName",
                        ResourceDocumentation.resource(
                                ResourceSnippetParameters.builder()
                                        .tag("signUp")
                                        .description("find Duplicate NickName")
                                        .summary("find Duplicate Nickname and if it is duplicate, give new Nickname")
                                        .queryParameters(
                                                parameterWithName("nickname").description("nickname")
                                        )
                                        .build()
                        )
                ));
    }

    @Order(7)
    @Test
    @DisplayName("POST:api/signUp/saveUser")
    void saveUserTest() throws Exception {

        InsertUserReqDto dto = InsertUserReqDto.builder()
                .email("zaxscd95@gmail.com")
                .password("abcd1234!")
                .emailAuthCode(emailauthCode)
                .nickName("abcd").build();

        mockMvc.perform(RestDocumentationRequestBuilders.post("/api/signUp/saveUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("findDuplicateNickName",
                        ResourceDocumentation.resource(
                                ResourceSnippetParameters.builder()
                                        .tag("signUp").description("save User")
                                        .summary("save User")
                                        .requestSchema(Schema.schema("InsertUserReqDto"))
                                        .requestFields(
                                                fieldWithPath("email").description("Email to find remove User").type(JsonFieldType.STRING),
                                                fieldWithPath("password").description("Email to find remove User").type(JsonFieldType.STRING),
                                                fieldWithPath("emailAuthCode").description("Email to find remove User").type(JsonFieldType.STRING),
                                                fieldWithPath("nickName").description("Email to find remove User").type(JsonFieldType.STRING)
                                        )
                                        .build()
                        )
                ));

    }

    @Order(8)
    @Test
    @DisplayName("GET:api/mainPost/findTopPostThumbnailList")
    void findThumbnail() throws Exception {

        //list.add(fieldWithPath("email").description("Email to find remove User").type(JsonFieldType.STRING));
        //make Test Request
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/mainPost/findTopPostThumbnailList"))
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("findThumbnailList",
                        ResourceDocumentation.resource(
                                ResourceSnippetParameters.builder()
                                        .tag("mainPost")
                                        .summary("find main Top post list")
                                        .description("find main Top post list")
                                        .responseSchema(Schema.schema("List<Thumbnail>"))
                                        .responseFields(
                                                fieldWithPath("[].postId").type(JsonFieldType.STRING).description("top Post Id").optional(),
                                                fieldWithPath("[].userId").type(JsonFieldType.STRING).description("top post's regist userId").optional(),
                                                fieldWithPath("[].title").type(JsonFieldType.STRING).description("top post title").optional(),
                                                fieldWithPath("[].contentSum").type(JsonFieldType.STRING).description("top post content Summary").optional(),
                                                fieldWithPath("[].thumbnailImg").type(JsonFieldType.STRING).description("top post thumbnail uri").optional(),
                                                fieldWithPath("[].regDt").type(JsonFieldType.STRING).description("top post registered date").optional()
                                        )
                                        .build()
                        )

                ));

    }

    @Order(9)
    @Test
    @DisplayName("PUT:api/post/savePost")
    void savePost() throws Exception {
        //make Test Request
        SavePostReqDtoTest reqDto = SavePostReqDtoTest
                .builder()
                .userId("5394e39b-a863-427d-8121-1a7e69")
                .postFile("1234")
                .postTitle("1234")
                .postType("N") // Normal
                .content("example-Conetent")
                .thumbnailImg("1234")
                .contentSum("1234....")
                .regDt("2018-12-15T10:00:00") //yyyy-MM-dd'T'HH:mm:ss.SSSZ
                .zoneId("KOR")
                .build();

        mockMvc.perform(RestDocumentationRequestBuilders.put("/api/post/savePost")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper
                                .writeValueAsString(reqDto)
                        )
                )
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("savePost",
                        ResourceDocumentation.resource(
                                ResourceSnippetParameters.builder()
                                        .tag("post").description("save User's post")
                                        .summary("save User's post")
                                        .requestSchema(Schema.schema("SavePostReqDto"))
                                        .requestFields(
                                                fieldWithPath("userId").description("UserId for post input").type(JsonFieldType.STRING),
                                                fieldWithPath("postFile").description("postFile for post input").type(JsonFieldType.STRING),
                                                fieldWithPath("postTitle").description("postTitle for post input").type(JsonFieldType.STRING),
                                                fieldWithPath("postType").description("postType for post input").type(JsonFieldType.STRING),
                                                fieldWithPath("content").description("content for post input").type(JsonFieldType.STRING),
                                                fieldWithPath("thumbnailImg").description("thumbnail img uri for post input").type(JsonFieldType.STRING),
                                                fieldWithPath("contentSum").description("content Summary for post input").type(JsonFieldType.STRING),
                                                fieldWithPath("regDt").description("regDt for post input").type(JsonFieldType.STRING),
                                                fieldWithPath("zoneId").description("ZoneId for post input").type(JsonFieldType.STRING)
                                        )
                                        .build()
                        )
                ));

    }


    @Order(10)
    @Test
    @DisplayName("POST:api/board/findBoardListByUserId")
    void findBoardListByUserId() throws Exception {

        try {
            //make Test Request
            findBoardListByUserIdDtoTest reqDto = findBoardListByUserIdDtoTest.builder().userId("1234").build();


            mockMvc.perform(RestDocumentationRequestBuilders.post("/api/board/findBoardListByUserId")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(mapper.writeValueAsString(reqDto))
                    )
                    .andExpect(status().isOk())
                    // Make API Document for result
                    .andDo(MockMvcRestDocumentationWrapper.document("findBoardListByUserId",
                            ResourceDocumentation.resource(
                                    ResourceSnippetParameters.builder()
                                            .tag("board").description("find User's board List")
                                            .summary("find User's board List")
                                            .requestSchema(Schema.schema("findBoardListByUserIdDto"))
                                            .requestFields(
                                                    fieldWithPath("userId").description("UserId for post input").type(JsonFieldType.STRING)
                                            )
                                            .build()
                            )
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Order(11)
    @Test
    @DisplayName("POST:api/post/findPostByBoardId")
    void findPostByBoardId() throws Exception {

        try {
            String boardId = "default";
            mockMvc.perform(RestDocumentationRequestBuilders.get("/api/post/findPostByBoardId?boardId=" + boardId)
                    )
                    .andExpect(status().isOk())
                    // Make API Document for result
                    .andDo(MockMvcRestDocumentationWrapper.document("findPostByBoardId",
                            ResourceDocumentation.resource(
                                    ResourceSnippetParameters.builder()
                                            .tag("board").description("find User's postList by boardId")
                                            .summary("find User's postList by boardId")
                                            .requestSchema(Schema.schema("List<Post>"))
                                            .responseFields(
                                                    fieldWithPath("[].postId").type(JsonFieldType.STRING).description("post Id").optional(),
                                                    fieldWithPath("[].userId").type(JsonFieldType.STRING).description("post's regist userId").optional(),
                                                    fieldWithPath("[].postTitle").type(JsonFieldType.STRING).description("post title").optional(),
                                                    fieldWithPath("[].postFile").type(JsonFieldType.STRING).description("post content Summary").optional(),
                                                    fieldWithPath("[].postType").type(JsonFieldType.STRING).description("post thumbnail uri").optional(),
                                                    fieldWithPath("[].regDt").type(JsonFieldType.STRING).description("post registered date").optional(),
                                                    fieldWithPath("[].boardId").type(JsonFieldType.STRING).description("post's board id").optional()
                                            )
                                            .build()
                            )
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Order(12)
    @Test
    @DisplayName("POST:api/post/findPostByPostId")
    void findPostByPostId() throws Exception {

        try {
            String postId = "1234";
            mockMvc.perform(RestDocumentationRequestBuilders.get("/api/post/findPostByPostId?postId=" + postId))
                    .andExpect(status().isOk())
                    // Make API Document for result
                    .andDo(MockMvcRestDocumentationWrapper.document("findPostByPostId",
                            ResourceDocumentation.resource(
                                    ResourceSnippetParameters.builder()
                                            .tag("board").description("find User's post detail by postId")
                                            .summary("find User's post detail by postId")
                                            .requestSchema(Schema.schema("Post"))
                                            .responseFields(
                                                    fieldWithPath("postId").type(JsonFieldType.STRING).description("post Id").optional(),
                                                    fieldWithPath("userId").type(JsonFieldType.STRING).description("post's regist userId").optional(),
                                                    fieldWithPath("postTitle").type(JsonFieldType.STRING).description("post title").optional(),
                                                    fieldWithPath("postFile").type(JsonFieldType.STRING).description("post content Summary").optional(),
                                                    fieldWithPath("postType").type(JsonFieldType.STRING).description("post thumbnail uri").optional(),
                                                    fieldWithPath("regDt").type(JsonFieldType.STRING).description("post registered date").optional(),
                                                    fieldWithPath("boardId").type(JsonFieldType.STRING).description("post's board id").optional()
                                            )
                                            .build()
                            )
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Order(13)
    @Test
    @DisplayName("POST:api/post/findCommentByPostId")
    void findCommentByPostId() throws Exception {

        try {
            String postId = "1234";
            mockMvc.perform(RestDocumentationRequestBuilders.get("/api/post/findCommentByPostId?postId=" + postId))
                    .andExpect(status().isOk())
                    // Make API Document for result
                    .andDo(MockMvcRestDocumentationWrapper.document("findCommentByPostId",
                            ResourceDocumentation.resource(
                                    ResourceSnippetParameters.builder()
                                            .tag("comment").description("find User's comments by postId")
                                            .summary("find User's comments by postId")
                                            .requestSchema(Schema.schema("Comment"))
                                            /*.responseFields(
                                                    fieldWithPath("postId").type(JsonFieldType.STRING).description("post Id").optional(),
                                                    fieldWithPath("userId").type(JsonFieldType.STRING).description("post's regist userId").optional(),
                                                    fieldWithPath("postTitle").type(JsonFieldType.STRING).description("post title").optional(),
                                                    fieldWithPath("postFile").type(JsonFieldType.STRING).description("post content Summary").optional(),
                                                    fieldWithPath("postType").type(JsonFieldType.STRING).description("post thumbnail uri").optional(),
                                                    fieldWithPath("regDt").type(JsonFieldType.STRING).description("post registered date").optional(),
                                                    fieldWithPath("boardId").type(JsonFieldType.STRING).description("post's board id").optional()
                                            )*/
                                            .build()
                            )
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
