from django.db import models

# Create your models here.
class UserDetails(models.Model):
	username = models.CharField(max_length=20,unique=True)
	password = models.CharField(max_length=20)
	email = models.EmailField(unique=True)
	mobilenum = models.CharField(max_length=15,unique=True)