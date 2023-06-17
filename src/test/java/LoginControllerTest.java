import com.epages.restdocs.apispec.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.objeto.SpringBootApplicationMain;
import com.objeto.login.dto.request.FindUserReqDto;
import com.objeto.login.dto.request.InsertUserReqDto;
import com.objeto.login.dto.request.RemoveUserReqDto;
import com.objeto.login.dto.request.UpdateUserReqDto;
import com.objeto.signup.dto.request.SendVarificationEmailReqDto;
import org.hibernate.query.QueryParameter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.request.ParameterDescriptor;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.queryParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SpringBootApplicationMain.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("POST:api/login/findUser")
    void loginTest() throws Exception {
        //make Test Request
        FindUserReqDto dto = FindUserReqDto.builder()
                .email("zaxscd95@naver.com")
                .password("5555")
                .build();
        ResultActions actions = mockMvc.perform(RestDocumentationRequestBuilders.post("/api/login/findUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("findUser",
                        ResourceSnippetParameters.builder()
                            .tag("login")
                            .summary("user Login function")
                            .description("when user login, give user JwtToken sample to test")
                            .requestSchema(Schema.schema("LoginReqDto.email"))
                            .requestSchema(Schema.schema("LoginReqDto.password")),
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())
        ));

        System.out.println("====================================================");
        System.out.println("====================================================");
        System.out.println(actions.andReturn().getResponse().getContentAsString());
        System.out.println("====================================================");
        System.out.println("====================================================");

    }

    @Test
    @DisplayName("POST:api/login/saveUser")
    void insertUserTest() throws Exception {
        //make Test Request
        InsertUserReqDto dto = InsertUserReqDto.builder()
                                .email("abcd" + Math.random() + "@naver.com")
                                .password("abcd1234!")
                                .nickName("abcd").build();
        mockMvc.perform(RestDocumentationRequestBuilders.post("/api/login/saveUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("saveUser",
                        ResourceSnippetParameters.builder()
                                .tag("login")
                                .summary("save User test")
                                .description("save User's email, password, nickname")
                                .requestSchema(Schema.schema("InsertUserReqDto.email"))
                                .requestSchema(Schema.schema("InsertUserReqDto.password"))
                                .requestSchema(Schema.schema("InsertUserReqDto.nickname")),
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())
                ));

    }

    @Test
    @DisplayName("PUT:api/login/updateUser")
    void modifyUserTest() throws Exception {
        //make Test Request
        UpdateUserReqDto dto = UpdateUserReqDto.builder().nickname("7777").password("5555").build();
        mockMvc.perform(RestDocumentationRequestBuilders.put("/api/login/updateUser")
                        // Need Jwt Token that findUser method provide
                        .header("X-AUTH-TOKEN", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1YWRiODUzZi1hODFhLTQ3OGEtOTdiYS04MDhkOTgiLCJ1c2VySWQiOiI1YWRiODUzZi1hODFhLTQ3OGEtOTdiYS04MDhkOTgiLCJpYXQiOjE2ODY5OTgwNDMsImV4cCI6MTcwNDk5ODA0M30.FQ7DcO7IkbB6MthEGMzL8wRpQ4cRTXvDyWlV7FisH_c")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("updateUser",
                        ResourceSnippetParameters.builder()
                                .tag("login")
                                .summary("update User test")
                                .description("update User Information")
                                .requestSchema(Schema.schema("UpdateUserReqDto.email")),
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())
                ));

    }

    @Test
    @DisplayName("DELETE:api/login/removeUser")
    void removeUserTest() throws Exception {
        //make Test Request
        RemoveUserReqDto dto = RemoveUserReqDto.builder().email("zaxscd95@naver.com").build();
        mockMvc.perform(RestDocumentationRequestBuilders.delete("/api/login/removeUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("removeUser",
                        ResourceSnippetParameters.builder()
                                .tag("login")
                                .summary("remove User Test")
                                .description("remove user")
                                .requestSchema(Schema.schema("RemoveUserReqDto.email")),
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())
                ));

    }


    @Test
    @DisplayName("POST:api/signIn/sendVarificationEmail")
    void sendVarificationEmail() throws Exception {
        //make Test Request
        SendVarificationEmailReqDto dto = SendVarificationEmailReqDto.builder().email("zaxscd95@gmail.com").build();
        mockMvc.perform(RestDocumentationRequestBuilders.post("/api/signUp/sendVarificationEmail")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("sendVarificationEmail",
                        ResourceSnippetParameters.builder()
                                .tag("signUp")
                                .summary("send Varification Email")
                                .description("send Varification Email")
                                .requestSchema(Schema.schema("SendVarificationEmailReqDto.email")),
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())
                ));

    }


    @Test
    @DisplayName("GET:api/signIn/checkEmailCode/{code}")
    void redisTest() throws Exception {
        //make Test Request
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/signUp/checkEmailCode/" + "9b08af2d-44c5-4bf3-8072-b4b771"))
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("checkEmailCode",
                        ResourceSnippetParameters.builder()
                                .tag("signUp")
                                .summary("send Varification redis")
                                .description("check Varification code in redis. usually it add to Mail Content URL Path Variable."),
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())
                ));

    }

    @Test
    @DisplayName("GET:api/signUp/findDuplicateEmail")
    void findDuplicateEmail() throws Exception {
        //make Test Request
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/signUp/findDuplicateEmail?email=" + "zaxscd95@naver.com"))
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("findDuplicateEmail",
                        ResourceSnippetParameters.builder()
                                .queryParameters(
                                        parameterWithName("email").description("email")
                                )
                                .responseFields(
                                        fieldWithPath("email").description("email").type(JsonFieldType.STRING)
                                )
                                .tag("signUp")
                                .summary("find Duplicated Email")
                                .description("find Duplicated Email"),
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())
                ));
    }


    @Test
    @DisplayName("GET:api/signUp/findDuplicateNickName")
    void findDuplicateNickName() throws Exception {
        //make Test Request
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/signUp/findDuplicateNickName?nickname=" + "abcd"))
                .andExpect(status().isOk())
                // Make API Document for result
                .andDo(MockMvcRestDocumentationWrapper.document("findDuplicateNickName",
                        ResourceDocumentation.resource(
                                ResourceSnippetParameters.builder()
                                        .description("유저 생성")
                                        .queryParameters(
                                            parameterWithName("nickname").description("nickname")
                                        )
                                        .build()
                        )
                ));
    }
}
