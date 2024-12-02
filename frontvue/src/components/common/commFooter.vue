<template>
    <footer class="footer">
        <div class="footer-content">
            <p>&copy; 2024 Playground. All Rights Reserved.</p>
            <div class="footer-links">
                <a href="#">Privacy Policy</a>
                <a href="#">Terms of Service</a>
                <a href="#">Contact</a>
                <a href="#">Hello</a>
            </div>
        </div>
</footer>
</template>

<script>
export default {
    name: 'commFooter',
    data() {
        return {

        }
    },
    methods: {

    },
    created() {

    },
}

</script>

<style>
.footer {
  background-color: #333;
  color: white;
  padding: 20px 0;
  position: relative;
  bottom: 0;
  width: 100%;
  text-align: center;
  font-size: 14px;
}

.footer-content {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.footer-links {
  margin-top: 10px;
}

.footer-links a {
  color: #aaa;
  text-decoration: none;
}

.footer-links a:not(:last-child)::after {
  content: "|"; /* 구분 기호 */
  color: #aaa;
  margin: 0 10px;
}

.footer-links a:hover {
  color: #fff;
  text-decoration: underline;
}
</style>
