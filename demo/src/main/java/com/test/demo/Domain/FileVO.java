import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class FileVO {
    
    private Long id;
    
    private String orgNm;
    
    private String savedNm;
    
    private String savedPath;

    public FileVO(Long id, String orgNm, String savedNm, String savedPath) {
        this.id = id;
        this.orgNm = orgNm;
        this.savedNm = savedNm;
        this.savedPath = savedPath;
    }
}