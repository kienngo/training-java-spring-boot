package com.example.demo.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import com.example.demo.model.ErrorMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Tất cả các Exception không được khai báo sẽ được xử lý tại đây
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleAllException(Exception ex, WebRequest request) {
        // quá trình kiểm soat lỗi diễn ra ở đây
        return new ErrorMessage(10000, ex.getLocalizedMessage());
    }

    /**
     * Tất cả lỗi NoResourceFoundException xử lý ở đây
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleNoResourceException(NoResourceFoundException ex, WebRequest request) {
        // quá trình kiểm soat lỗi diễn ra ở đây
        return new ErrorMessage(410, ex.getLocalizedMessage());
    }


    /**
     * IndexOutOfBoundsException sẽ được xử lý riêng tại đây
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage indexOutOfBoundException(Exception ex, WebRequest request) {
        return new ErrorMessage(10100, "Đối tượng không tồn tại");
    }

    /**
     * MethodArgumentNotValidException sẽ được xử lý riêng tại đây
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handlingValidation(MethodArgumentNotValidException ex) {
        return new ErrorMessage(10200, ex.getLocalizedMessage());
    }
}
