namespace dotnetbackend.Model;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("mechanic")]
public class Mechanic
    {
       [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Column("mechanic_id")]
        public long Id { get; set; }

        [Required]
        [StringLength(255)]
        [Column("mechanic_name")]
        public string Name { get; set; }

        [Required]
        [StringLength(255)]
        public string Email { get; set; }

        [Required]
        [StringLength(255)]
        public string Password { get; set; }

        [Required]
        [StringLength(15)]
        public string Contactno { get; set; }

        [Required]
        [StringLength(15)]
        public long Age { get; set; }

        [Required]
        [Column("created_at", TypeName = "datetime2")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public DateTime CreateDate { get; set; }

        [Required]
        [StringLength(255)]
        public string Location { get; set; }

        [Required]
        [StringLength(255)]
        public string Address { get; set; }

        [Required]
        [StringLength(255)]
        public string Gender { get; set; }


        public Mechanic(long id, string name, string email, string password, string contactno, long age, DateTime createDate, string address, string location, string gender)
        {
            Id = id;
            Name = name;
            Email = email;
            Password = password;
            Contactno = contactno;
            Age = age;
            CreateDate = createDate;
            Address = address;
            Location = location;
            Gender = gender;
        }

        public override string ToString()
        {
            return $"Mechanic {{ Id={Id}, Name={Name}, Email={Email}, Password={Password}, ContactNo={Contactno}, Age={Age}, CreateDate={CreateDate}, Address={Address}, Location={Location}, Gender={Gender} }}";
        }
    }
