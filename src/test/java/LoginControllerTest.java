import com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper;
import com.epages.restdocs.apispec.ResourceSnippetParameters;
import com.epages.restdocs.apispec.Schema;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.objeto.SpringBootApplicationMain;
import com.objeto.login.dto.request.InsertUserReqDto;
import com.objeto.login.dto.request.RemoveUserReqDto;
import com.objeto.login.dto.request.UpdateUserReqDto;
import com.objeto.signup.dto.request.SendVarificationEmailReqDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SpringBootApplicationMain.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("GET:api/login/findUser")
    void loginTest() throws Exception {
        //make Test Request
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/login/findUser")
                        .param("email", "zaxscd95@naver.com")
                        .param("password", "dldbthd1234")
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
        UpdateUserReqDto dto = UpdateUserReqDto.builder().email("zaxscd95@naver.com").build();
        mockMvc.perform(RestDocumentationRequestBuilders.put("/api/login/updateUser")
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
}
