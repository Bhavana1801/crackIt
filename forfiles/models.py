from django.db import models

# Create your models here.
class UserDetails(models.Model):
	username = models.CharField(max_length=20,unique=True)
	password = models.CharField(max_length=20)
	email = models.EmailField(unique=True)
	mobilenum = models.CharField(max_length=15,unique=True)
class ProfileImage(models.Model):
	keyword = models.CharField(max_length=20)
	domain = models.CharField(max_length=20)
	image = models.FileField(upload_to='files2\\')
	username = models.CharField(max_length=30)
	# def __unicode__(self):
	# 	return self.username
