package com.objeto.post.dto.request;

import com.objeto.post.dto.PostDto;
import com.objeto.security.encrypt.EncryptUtils;
import lombok.*;

@Getter
@Builder
@RequiredArgsConstructor
public class SavePostReqDtoTest {

    private final String userId;

    private final String postTitle;

    private final String postType;

    private final String postFile;

    private final String content;

    private final String contentSum;

    private final String thumbnailImg;

    private final String regDt;

    private final String zoneId;
}
