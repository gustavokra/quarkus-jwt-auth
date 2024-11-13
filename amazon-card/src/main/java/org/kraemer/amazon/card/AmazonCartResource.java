package org.kraemer.amazon.card;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cart")
@ApplicationScoped
public class AmazonCartResource {

    List<AmazonItem> items = new ArrayList<>();

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems() {
        return Response.ok(items).build();
    }

    @POST
    @RolesAllowed({"admin", "writer"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addItem(AmazonItem newItem) {
        items.add(newItem);
        return Response.ok(items).build();
    }

    @Path("{id}")
    @RolesAllowed({"admin"})
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteItem(@PathParam("id") Long id) {
        items.stream()
            .filter(item -> item.getId().equals(id))
            .findFirst()
            .ifPresent(item -> items.remove(item));

        return Response.noContent().build();
    }

}
