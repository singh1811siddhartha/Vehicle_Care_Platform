namespace dotnetbackend.DAL;

    using dotnetbackend.Model;
    using MySql.Data.MySqlClient;
    using System;
    using System.Collections.Generic;
    using System.Data;

    public class UsersDataAccess
    {
        public static string conString = @"server=localhost; port=3306; user=root; password=1811@sid; database=vehicle_care_platform";
    private long id;
    private string? name;
    private string? email;
    private string? password;
    private string? contactno;
    private long age;
    private DateTime createDate;
    private string? address;
    private string? location;
    private string? gender;

    public List<User> GetAllUsers()
        {
            List<User> allUsers = new List<User>();
            using (MySqlConnection connection = new MySqlConnection(conString))
            {
                string query = "SELECT * FROM users";
                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    try
                    {
                        connection.Open();
                        using (MySqlDataReader reader = command.ExecuteReader())
                        {   
                            
                            while (reader.Read())
                            {
                                User user = new User(id, name, email, password, contactno, age, createDate, address, location, gender)
                                {
                                    Id = Convert.ToInt64(reader["user_id"]),
                                    Name = reader["user_name"].ToString(),
                                    Email = reader["email"].ToString(),
                                    Password = reader["password"].ToString(),
                                    Contactno = reader["contactno"].ToString(),
                                    Age = Convert.ToInt64(reader["age"]),
                                    CreateDate = Convert.ToDateTime(reader["created_at"]),
                                    Address = reader["address"].ToString(),
                                    Location = reader["location"].ToString(),
                                    Gender = reader["gender"].ToString()
                                };
                                allUsers.Add(user);
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine(e.Message);
                    }
                }
            }
            return allUsers;
        }

        public void SaveNewUser(User user)
        {
            using (MySqlConnection connection = new MySqlConnection(conString))
            {
                string query = $"INSERT INTO users(user_name, email, password, contactno, age, created_at, address, location, gender) VALUES('{user.Name}', '{user.Email}', '{user.Password}', '{user.Contactno}', {user.Age}, '{user.CreateDate:yyyy-MM-dd HH:mm:ss}', '{user.Address}', '{user.Location}', '{user.Gender}')";
                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    try
                    {
                        connection.Open();
                        command.ExecuteNonQuery();
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine(e.Message);
                    }
                }
            }
        }

        public void DeleteUserById(long id)
        {
            using (MySqlConnection connection = new MySqlConnection(conString))
            {
                string query = $"DELETE FROM users WHERE user_id = {id}";
                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    try
                    {
                        connection.Open();
                        command.ExecuteNonQuery();
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine(e.Message);
                    }
                }
            }
        }

        public void UpdateUser(User user)
        {
            using (MySqlConnection connection = new MySqlConnection(conString))
            {
                string query = $"UPDATE users SET user_name='{user.Name}', email='{user.Email}', password='{user.Password}', contactno='{user.Contactno}', age={user.Age}, created_at='{user.CreateDate:yyyy-MM-dd HH:mm:ss}', address='{user.Address}', location='{user.Location}', gender='{user.Gender}' WHERE user_id={user.Id}";
                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    try
                    {
                        connection.Open();
                        command.ExecuteNonQuery();
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine(e.Message);
                    }
                }
            }
        }
    }

