import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")

public class AccountController {
  private final AccountService accountService;

   public AccountController(AccountService accountService) {
	this.accountService = accountService;
}

   @PostMapping("/create")
    
  ResponseEntity<CreateAccountDto> createAccount(@Valid @RequestBody CreateAccountDto request){
        accountService.createAccount(request);

    return ResponseEntity.status(HttpStatus.OK).body(request);

  }


}
