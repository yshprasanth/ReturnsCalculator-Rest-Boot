package com.returns.calculator.rest;

import com.returns.calculator.domain.json.Trade;
import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.service.template.AbstractTradeProcessor;
import io.swagger.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Main Rest Controller for this prototype
 *
 */
@RestController
public class ReturnsCalcController {

    Logger logger = LogManager.getLogger(getClass());

    @Autowired
    @Qualifier("fxTradeProcessor")
    private AbstractTradeProcessor fxTradeProcessor;

    /**
     * Swagger Config included in annotation.
     *      *
     * This will create new Trade object from given json.
     *
     *
     * @param trade
     * @return
     */
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
            logger.info("Created new trade : " + tradeId);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(-1, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    /**
     * This is provide the list of trades filtered by clientName.
     *
     * @param clientName
     * @return
     */
    @ApiOperation(value = "listAllTradesForClient", nickname = "listAllTradesForClient")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ClientName", value = "Client Name", required = true, dataType = "String")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "Error while processing", response = ResponseEntity.class)
    })
    @RequestMapping(method= RequestMethod.GET, path="/listAllTradesForClient", produces = "application/json")
    public ResponseEntity<List<FxTrade>> listTradesForClient(@RequestParam String clientName) {

        ResponseEntity<List<FxTrade>> responseEntity = null;
        try {
            List<FxTrade> list = fxTradeProcessor.getTradesPerClient(clientName);
            responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
            logger.info("Trade count by clientName: " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    /**
     * This will provide the list of trades filtered by productType.
     *
     * @param productType
     * @return
     */
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
            logger.info("Trade count by productName: " + list.size());
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
