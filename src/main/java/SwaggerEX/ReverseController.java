package SwaggerEX;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ReverseController {

    @GetMapping("/{name}")
    @Operation(summary = "Returns user's name input")
    public String getName(@Parameter(description = "The user request param") @PathVariable String name) {
        return name;
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "return input name", content = {
                    @Content(mediaType = "application/string")
            })
    })
    @PostMapping("/reverse")
    @Operation(summary = "Returns user's name reversed")
    public String reverse(@Parameter(description = "The user request body") @RequestBody String name) {
        return new StringBuilder(name).reverse().toString();
    }
}
