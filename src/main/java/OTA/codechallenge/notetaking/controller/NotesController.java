package OTA.codechallenge.notetaking.controller;

import OTA.codechallenge.notetaking.dto.ActionResponseDTO;
import OTA.codechallenge.notetaking.dto.DTOI;
import OTA.codechallenge.notetaking.dto.NoteDTO;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public final class NotesController implements InitializingBean {
    private static Map<Long, NoteDTO> notes = Collections.synchronizedMap(new HashMap<Long, NoteDTO>());

    @PostMapping(value = "/notes", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    synchronized public ResponseEntity<DTOI> createNote(@RequestBody NoteDTO note) {
        note.setId(notes.size());
        notes.put(note.getId(), note);

        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping(value = "/notes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Long, NoteDTO>> getAllNotes() {
        return new ResponseEntity<Map<Long, NoteDTO>>(notes, HttpStatus.OK);
    }

    @GetMapping(value = "/notes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DTOI> getNote(@PathVariable long id) {
        if(!notes.containsKey(id))
            return new ResponseEntity<>(new ActionResponseDTO("Note of id "
                    + id + " does not exist"), HttpStatus.OK);

        return new ResponseEntity<>(notes.get(id), HttpStatus.OK);
    }

    @PutMapping(value = "/notes/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    synchronized public ResponseEntity<DTOI> updateNote(@PathVariable long id, @RequestBody NoteDTO note) {
        if(!notes.containsKey(id))
            return new ResponseEntity<>(new ActionResponseDTO("Note of id "
                    + id + " does not exist."), HttpStatus.OK);

        NoteDTO updatedNote = notes.get(id);
        updatedNote.setTitle(note.getTitle());
        updatedNote.setNote(note.getNote());

        return new ResponseEntity<>(updatedNote, HttpStatus.OK);
    }

    @DeleteMapping(value = "/notes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    synchronized public ResponseEntity<DTOI> deleteNote(@PathVariable long id) {
        if(notes.containsKey(id))
            return new ResponseEntity<>(new ActionResponseDTO("Note of id "
                    + id + " does not exist"), HttpStatus.OK);

        notes.remove(id);

        return new ResponseEntity<>(new ActionResponseDTO("Note of id "
                + id + " has been deleted"), HttpStatus.OK);
    }

    @Override
    public final void afterPropertiesSet() {
        NoteDTO note = new NoteDTO();

        note.setId(0L);
        note.setTitle("Title");
        note.setNote("This is a note note.");

        notes.put(0L, note);
    }
}
