package com.returns.calculator.rest;

import java.util.concurrent.atomic.AtomicLong;

import com.returns.calculator.domain.Domain;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnsCalcController {

    private static final String template = "Interest is: %d!";
    private final AtomicLong counter = new AtomicLong();

    @ApiOperation(value = "calculateReturns", nickname = "calculateReturns")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Principal", value = "Principal", required = false, dataType = "long", paramType = "query", defaultValue="100")
    })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = Domain.class)
    })
    @RequestMapping(method= RequestMethod.GET, path="/calculateReturns", produces = "application/json")
    public Domain calculateReturns(@RequestParam(value="Principal", defaultValue="100") Long principal) {
        return new Domain(counter.incrementAndGet(),
                String.format(template, principal));
    }
}
