package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Entry;
import ch.zli.m223.service.EntryService;

@Path("/entries")
@Tag(name = "Entries", description = "Handling of entries")
public class EntryController {

    @Inject
    EntryService entryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Entries.", description = "Returns a list of all entries.")
    public List<Entry> index() {
        return entryService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new entry.", description = "Creates a new entry and returns the newly added entry.")
    public Entry create(Entry entry) {
       return entryService.createEntry(entry);
    }


    @POST
    @Path("/edit/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Edits an entry.", description = "Edites an entry and returns the entry.")
    public Response edit(@PathParam("id") Long id, Entry entry) {
        Entry editEntry = entryService.findById(id);
        if (editEntry == null) {
        return Response.status(Response.Status.NOT_FOUND).build();
       }
        entryService.editEntry(id, entry);
       return Response.noContent().build();
    }


    @DELETE
    @Path("/delete/{id}")
    @Operation(summary = "Delete an entry.", description = "Deletes an entry with specified id.")
    public Response delete(@PathParam("id") Long id) {
       Entry entry = entryService.findById(id);
       if (entry == null) {
        return Response.status(Response.Status.NOT_FOUND).build();
       }
       entryService.deleteEntry(id);
        return Response.noContent().build();
    }
}
