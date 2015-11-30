from django import forms
from models import UserDetails
class UserDetailsForm(forms.ModelForm):
	class Meta:
		model = UserDetails
		fields = ['username','password','email','mobilenum']