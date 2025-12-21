@RestController
@RequestMapping("/api/room-assignments")
@Tag(name = "Room Assignments")
public class RoomAssignmentController {
    private final RoomAssignmentService service;
    public RoomAssignmentController(RoomAssignmentService service) { this.service = service; }

    @PostMapping("/") public Object assign(@RequestBody Object assignment) { return service.assignRoom(assignment); }
}