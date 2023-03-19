namespace dotnetbackend.Model;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;


    [Table("vehicles")]
    public class Vehicles 
    {
        [Key]
        [Column("id")]
        public long Id { get; set; }

        [Column("user_id")]
        [Required]
        public long UserId { get; set; }

        [Column("make")]
        [Required]
        public string Make { get; set; }

        [Column("model")]
        [Required]
        public string Model { get; set; }

        [Column("year")]
        [Required]
        public int Year { get; set; }

        [Column("color")]
        [Required]
        public string Color { get; set; }

        [Column("license_plate")]
        [Required]
        public string LicensePlate { get; set; }

        [Column("created_at")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public DateTime CreatedAt { get; set; }

        public Vehicles(long id, long userId, string make, string model, int year, string color, string licensePlate, DateTime createdAt)
        {
            Id = id;
            UserId = userId;
            Make = make;
            Model = model;
            Year = year;
            Color = color;
            LicensePlate = licensePlate;
            CreatedAt = createdAt;
        }

        public override string ToString()
        {
            return "Vehicles [id=" + Id + ", user_id=" + UserId + ", make=" + Make + ", model=" + Model + ", year=" + Year
                + ", color=" + Color + ", licensePlate=" + LicensePlate + ", createdAt=" + CreatedAt + "]";
        }
    }

