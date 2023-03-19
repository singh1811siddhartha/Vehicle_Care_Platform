using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Cors;
namespace AdminController;

using dotnetbackend.DAL;
using dotnetbackend.Model;


[ApiController]
[Route("api/[controller]")]
public class AdminController : ControllerBase
{
    private readonly ILogger<AdminController> _logger;

    public AdminController(ILogger<AdminController> logger)
    {
        _logger = logger;
    }

    [HttpGet]
    [EnableCors()]
    public IEnumerable<Admin> GetAllAdmin()
    {
        List<Admin> admin = AdminDataAccess.GetAlladmin();
        return admin;
    }

    [HttpPost]
    [EnableCors()]
    public IActionResult InsertNewAdmin(Admin admin)
    {
        AdminDataAccess.SaveNewAdmin(admin);
        return Ok(new { message = "Admin created" });
    }

    [Route("{id}")]
    [HttpDelete]
    [EnableCors()]
    public IActionResult DeleteOneAdmin(int id)
    {
        AdminDataAccess.DeleteAdminById(id);
        return Ok(new { message = "Admin deleted" });
    }

    [Route("{id}")]
    [HttpPut]
    [EnableCors()]
    public IActionResult UpdateAdmin(int id, [FromBody] Admin admin)
    {
        AdminDataAccess.UpdateAdmin(id, admin);
        return Ok(new { message = "Admin updated" });
    }
}