from django import forms
from models import UserDetails,ProfileImage
class UserDetailsForm(forms.ModelForm):
	class Meta:
		model = UserDetails
		fields = ['username','password','email','mobilenum']
class ProfileImageForm(forms.Form):
	image = forms.FileField(label="select a profile image")
