from django.shortcuts import render
from django.http import HttpResponseRedirect, HttpResponse
from django.shortcuts import render_to_response
from forms import UserDetailsForm
from models import UserDetails
from django.contrib import auth
from django.shortcuts import get_object_or_404
from django.core.context_processors import csrf
from django.template import RequestContext
# Create your views here.
def main(request):
    return render_to_response('main.html')
# def registrationpage(request):
#     return render_to_response('registration.html')
def login(request):
	args = {}
	args.update(csrf(request))
	return render_to_response('login.html',args)
def auth_view(request):
	print "came"
	username = request.GET.get('username','')
	password = request.GET.get('password','')
	try:
		user = UserDetails.objects.get(username = username)
		print user
		print username
	except UserDetails.DoesNotExist:
		html = "<html><body>userdetails does not exist</body></html>"
		return HttpResponse(html)
	if user is not None:
		if user.password == password:
			request.session['username'] = user.username
			return HttpResponseRedirect('/myapp/profile/')
		else:
			html = "<html><body>Password incorrect</body></html>"
			return HttpResponse(html)
	else:
		html = "<html><body>username incorrect</body></html>"
		return HttpResponse(html)
def registration(request):
	args = {}
	args.update(csrf(request))
	return render_to_response('registration.html',args)
def signup(request):
	form = UserDetailsForm()
	if request.POST:
		form = UserDetailsForm(request.POST)
		if form.is_valid():
			form.save()
<<<<<<< HEAD
			return HttpResponseRedirect('/myapp/main/')
=======
			return HttpResponseRedirect('/myapp/main')
>>>>>>> 811e83df86e3591613c56b0b0c790abcddc6048a
		else:
			temp = "<html><boby>Email-id or the mobile number already exists</body></html>"
			return HttpResponse(temp)
	return render_to_response('registration.html',{'form':form}, context_instance=RequestContext(request))
def profile(request):
<<<<<<< HEAD
    return render_to_response('profile.html')
def upload_file(request):
    return render_to_response('uploadFile.html')
=======
    return render_to_response('profile.html')
>>>>>>> 811e83df86e3591613c56b0b0c790abcddc6048a
