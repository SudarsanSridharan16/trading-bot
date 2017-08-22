package io.github.t73liu.rest;

import io.github.t73liu.model.ExceptionWrapper;
import io.github.t73liu.service.PoloniexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Component
@Path("/poloniex")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api("PoloniexResource")
@ApiResponses(@ApiResponse(code = 500, message = "Internal Server Error", response = ExceptionWrapper.class))
public class PoloniexResource {
    private final PoloniexService service;

    @Autowired
    public PoloniexResource(PoloniexService service) {
        this.service = service;
    }

    @GET
    @Path("/tickers")
    @ApiResponses(@ApiResponse(code = 200, message = "Retrieved Tickers in Poloniex", response = Map.class))
    public Response getTicker() throws Exception {
        return Response.ok(service.getTickers()).build();
    }

    @GET
    @Path("/balance")
    @ApiResponses(@ApiResponse(code = 200, message = "Retrieved Balance in Poloniex", response = Map.class))
    public Response getBalance() throws Exception {
        return Response.ok(service.getBalance()).build();
    }

    @GET
    @Path("/orders/open")
    @ApiResponses(@ApiResponse(code = 200, message = "Retrieved Open Orders in Poloniex", response = Map.class))
    public Response getOpenOrders() throws Exception {
        return Response.ok(service.getOpenOrders()).build();
    }
}