<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center pt-3">

      </div>
    </div>
    <div class="row">
      <div class="col-12 text-center pt-3">
        <div class="signup-div flex-item-border">
          <h2 class="pt-4 ps-4">Create Account</h2>
          <form class="pt-4 px-4">
            <div class="form-group">
              <label for="Email">Email</label>
              <input type="email" class="form-control" required>
            </div>
            <div class="form-row">
              <div class="col">
                <form-group>
                  <label>First Name</label>
                  <input type="text" class="form-control" required>
                </form-group>
              </div>
              <div class="col">
                <form-group>
                  <label>Last Name</label>
                  <input type="text" class="form-control" required>
                </form-group>
              </div>
            </div>
            <div class="form-group">
              <label for="Password">Password</label>
              <input type="password" class="form-control" required>
            </div>
            <div class="form-group">
              <label for="ConfirmPassword">Confirm Password</label>
              <input type="password" class="form-control" required>
            </div>
            <button type="button" class="btn btn-primary mt-2">Create Account</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SignupView"
}
</script>

<style scoped>

</style>