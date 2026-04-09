package re.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Setter
@Getter
public class FormRequest {
    private String email;
    private String cc;
    private String subject;
    private String content;
    private List<MultipartFile> file;
}
