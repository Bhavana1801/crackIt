from django.shortcuts import render_to_response

# Create your views here.
from django.http import HttpResponse

def homepage(request):
    return render_to_response('main.html')
def loginpage(request):
    return render_to_response('login.html')  
def registrationpage(request):
    return render_to_response('registration.html')
def profile(request):
	return render_to_response('profile.html') 
def uploadFile(request):
	return render_to_response('uploadFile.html') 