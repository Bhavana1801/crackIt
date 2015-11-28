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
			return HttpResponseRedirect('/myapp/main')
		else:
			temp = "<html><boby>Email-id or the mobile number already exists</body></html>"
			return HttpResponse(temp)
	return render_to_response('registration.html',{'form':form}, context_instance=RequestContext(request))