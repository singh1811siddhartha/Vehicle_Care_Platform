using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Cors;
namespace MechanicController;

using dotnetbackend.DAL;
using dotnetbackend.Model;


[ApiController]
[Route("api/[controller]")]
public class MechanicController : ControllerBase
{
    private readonly ILogger<MechanicController> _logger;

    public MechanicController(ILogger<MechanicController> logger)
    {
        _logger = logger;
    }

    [HttpGet]
    [EnableCors()]
    public IEnumerable<Mechanic> GetAllMechanic()
    {
        List<Mechanic> mech = MechanicDataAccess.GetAllmech();
        return mech;
    }

    [HttpPost]
    [EnableCors()]
    public IActionResult InsertNewMechanic(Mechanic mech)
    {
        MechanicDataAccess.SaveNewMechanic(mech);
        return Ok(new { message = "Mechanic created" });
    }

    [Route("{id}")]
    [HttpDelete]
    [EnableCors()]
    public IActionResult DeleteOneMechanic(int id)
    {
        MechanicDataAccess.DeleteMechanicById(id);
        return Ok(new { message = "Mechanic deleted" });
    }

    [Route("{id}")]
    [HttpPut]
    [EnableCors()]
    public IActionResult UpdateMechanic(int id, [FromBody] Mechanic mech)
    {
        MechanicDataAccess.UpdateMechanic(id, mech);
        return Ok(new { message = "Mechanic updated" });
    }
}