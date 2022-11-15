using ApiCshrap.Models;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddDbContext<GenDbContext>(options =>
{
    options.UseSqlServer(builder.Configuration.GetConnectionString("Conexao"));
});

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

//Libera todos os metodos de requisi��o e indica sua origem
app.UseCors(c =>
{
    c.AllowAnyHeader();
    c.AllowAnyMethod();
    //c.WithOrigins("http://localhost:19000");
    c.AllowAnyOrigin();
});

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
