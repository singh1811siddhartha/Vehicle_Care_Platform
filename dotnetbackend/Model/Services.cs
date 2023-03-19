namespace dotnetbackend.Model;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

[Table("services")]
public class Services
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Column("service_id")]
        public long Id { get; set; }

        [Required]
        [Column("mechanic_id")]
        public long MechanicId { get; set; }

        [Required]
        [Column("name")]
        public string Name { get; set; }

        [Required]
        [Column("description")]
        public string Description { get; set; }

        [Required]
        [Column("price", TypeName = "decimal(18,2)")]
        public decimal Price { get; set; }

        [Required]
        [Column("duration")]
        public string Duration { get; set; }

        [Required]
        [Column("location")]
        public string Location { get; set; }

        [Column("created_at", TypeName = "datetime2")]
        public DateTime CreatedAt { get; set; }

        public Services(long id, long mechanicId, string name, string description, decimal price, string duration, string location, DateTime createdAt)
        {
            Id = id;
            MechanicId = mechanicId;
            Name = name;
            Description = description;
            Price = price;
            Duration = duration;
            Location = location;
            CreatedAt = createdAt;
        }

        public override string ToString()
        {
            return "Services [id=" + Id + ", mechanic_id=" + MechanicId + ", name=" + Name + ", description=" + Description
                    + ", price=" + Price + ", duration=" + Duration + ", location=" + Location + ", createdAt=" + CreatedAt
                    + "]";
        }
    }