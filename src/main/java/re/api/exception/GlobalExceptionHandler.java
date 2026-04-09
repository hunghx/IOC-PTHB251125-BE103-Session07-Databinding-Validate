package re.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import re.api.dto.request.StudentAdd;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
// @RestController , @Advice : AOP
public class GlobalExceptionHandler {
    // Khi bất kì controller nào ném ra ngoài lệ
    // Thì ControllerAdvice sẽ lắng nghe và xử lí các ngoại lệ được khai báo
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<?> handlerMethodNotArgumentException(MethodArgumentNotValidException e){
        Map<String, String> errors = new HashMap<>(); // danh sách lỗi
        e.getFieldErrors().forEach(err->{
            errors.put(err.getField(), err.getDefaultMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);// 400
    }

    // NOT FOUND
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException e){
        Map<String, String> errors = new HashMap<>();
        errors.put("id", e.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND); // 404
    }
    @ExceptionHandler(ForeignKeyException.class)
    public ResponseEntity<?> handlerForeignKeyException(ForeignKeyException e){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", e.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); // 400
    }

    // Lưu ý ve thứ tự khai báo ngoại lệ cần xử lý : từ phạm vi bé đến lớn
}
