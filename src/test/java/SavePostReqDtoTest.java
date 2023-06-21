import com.objeto.post.dto.PostDto;
import com.objeto.security.encrypt.EncryptUtils;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class SavePostReqDtoTest {

    private String userId;

    private String postTitle;

    private String postType;

    private String postFile;

    private String content;

    private String contentSum;

    private String thumbnailImg;

    private String regDt;

    private String zoneId;

    public PostDto toEntity() {
        return PostDto.builder()
                .postId(EncryptUtils.randomIdGenerator())
                .userId(this.userId)
                .postFile(this.postFile)
                .postTitle(this.postTitle)
                .postType(this.postType)
                .content(this.content)
                .contentSum(this.contentSum)
                .thumbnailImg(this.thumbnailImg)
                .build();
    }

}
