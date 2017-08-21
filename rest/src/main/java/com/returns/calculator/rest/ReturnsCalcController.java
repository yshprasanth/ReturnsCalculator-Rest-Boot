package com.returns.calculator.rest;

import com.returns.calculator.domain.json.Trade;
import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.service.template.AbstractTradeProcessor;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ReturnsCalcController {

    @Autowired
    @Qualifier("fxTradeProcessor")
    private AbstractTradeProcessor fxTradeProcessor;

    @ApiOperation(value = "newTradeRequest", nickname = "newTradeRequest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Trade", value = "Trade JSON Object", required = true, dataType = "Trade")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Trade.class),
            @ApiResponse(code = 500, message = "Error while processing", response = Trade.class)
    })
    @RequestMapping(method= RequestMethod.POST, path="/newTradeRequest", produces = "application/json")
    public ResponseEntity<Integer> newTradeRequest(@RequestBody Trade trade) {

        ResponseEntity<Integer> responseEntity = null;
        try {
            Integer tradeId = fxTradeProcessor.execute(Optional.of(trade));
            responseEntity = new ResponseEntity<>(tradeId, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(-1, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @ApiOperation(value = "listAllTradesForClient", nickname = "listAllTradesForClient")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ClientName", value = "Client Name", required = true, dataType = "String")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "Error while processing", response = ResponseEntity.class)
    })
    @RequestMapping(method= RequestMethod.GET, path="/newTradeRequest", produces = "application/json")
    public ResponseEntity<List<FxTrade>> listTradesForClient(@RequestParam String clientName) {

        ResponseEntity<List<FxTrade>> responseEntity = null;
        try {
            List<FxTrade> list = fxTradeProcessor.getTradesPerClient(clientName);
            responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @ApiOperation(value = "listAllTradesForProductType", nickname = "listAllTradesForProductType")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ProductType", value = "Product Type", required = true, dataType = "ProductType")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "Error while processing", response = ResponseEntity.class)
    })
    @RequestMapping(method= RequestMethod.GET, path="/listAllTradesForProductType", produces = "application/json")
    public ResponseEntity<List<FxTrade>> listTradesForProductType(@RequestParam ProductType productType) {

        ResponseEntity<List<FxTrade>> responseEntity = null;
        try {
            List<FxTrade> list = fxTradeProcessor.getTradesPerProductType(productType);
            responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    public void setFxTradeProcessor(AbstractTradeProcessor<Trade, FxTrade> fxTradeProcessor) {
        this.fxTradeProcessor = fxTradeProcessor;
    }

}
