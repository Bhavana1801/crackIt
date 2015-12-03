from django import forms
from models import UserDetails,ProfileImage
class UserDetailsForm(forms.ModelForm):
	class Meta:
		model = UserDetails
		fields = ['username','password','email','mobilenum']
class ProfileImageForm(forms.Form):
	keyword = forms.CharField(max_length=20)
	domain = forms.CharField(max_length=20)
	image = forms.FileField(label="select a profile image")
	username = forms.CharField(max_length=20)